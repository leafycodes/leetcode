class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFormPairs(nums, mid, p)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean canFormPairs(int[] nums, int maxDiff, int p) {
        int count = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                count++;
                i += 2;
            } else {
                i++;
            }
            if (count >= p) {
                return true;
            }
        }
        return count >= p;
    }
}