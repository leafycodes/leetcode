class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int lastMin = -1;  
        int lastMax = -1;  
        int bad = -1;     
        
        long ans = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                bad = i;
            }
            if (nums[i] == minK) {
                lastMin = i;
            }
            if (nums[i] == maxK) {
                lastMax = i;
            }
            int validStart = Math.min(lastMin, lastMax);
            if (validStart > bad) {
                ans += validStart - bad;
            }
        }
        
        return ans;
    }
}