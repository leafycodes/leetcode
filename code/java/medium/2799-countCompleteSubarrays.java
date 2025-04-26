class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> totalDistinct = new HashSet<>();
        
        for (int num : nums) {
            totalDistinct.add(num);
        }
        int k = totalDistinct.size();
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                seen.add(nums[j]);
                if (seen.size() == k) {
                    count++;
                }
            }
        }
        
        return count;
    }
}