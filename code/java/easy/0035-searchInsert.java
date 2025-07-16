class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                left = mid;
                break;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return target > nums[left] ? left + 1 : left;
    }
}