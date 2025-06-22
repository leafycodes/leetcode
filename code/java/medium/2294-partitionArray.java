class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int res = 1;
        int start = nums[0];
        for (int num : nums) {
            if (num - start > k) {
                res++;
                start = num;
            }
        }
        return res;
    }
}