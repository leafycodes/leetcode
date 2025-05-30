class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(low, mid, nums);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(high, mid, nums);
                high--;
            }
        }

    }

    private void swap(int a, int b, int[] nums) {
        nums[a] = (nums[a] + nums[b]) - (nums[b] = nums[a]);
    }
}