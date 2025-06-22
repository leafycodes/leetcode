class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int[] prefixMinArray = new int[n];
        int[] suffixMaxArray = new int[n];

        prefixMinArray[0] = nums[0];
        suffixMaxArray[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefixMinArray[i] = Math.min(nums[i], prefixMinArray[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffixMaxArray[i] = Math.max(nums[i], suffixMaxArray[i + 1]);
        }

        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            if (prefixMinArray[i] < suffixMaxArray[i + 1]) {
                max = Math.max(max, suffixMaxArray[i + 1] - prefixMinArray[i]);
            }
        }
        return max;
    }
}