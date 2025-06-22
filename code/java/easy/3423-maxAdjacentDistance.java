class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            max = Math.max(max,
                    Math.abs(nums[i] - nums[next]));
        }

        return max;
    }
}