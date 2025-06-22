class Solution {
    public int search(int[] nums, int target) {
        int shift = findShift(nums);

        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;

            int realMid = (mid + shift) % nums.length;

            if (nums[realMid] == target) {
                return realMid;
            } else if (nums[realMid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private static int findShift(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;

        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

// way 2

class Solution {
    public int search(int[] nums, int target) {
        return searchInRotatedArray(nums, target, 0, nums.length - 1);
    }

    private int searchInRotatedArray(int[] nums, int key, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == key) {
            return mid;
        }

        if (nums[left] <= nums[mid]) {
            if (nums[left] <= key && key <= nums[mid]) {
                return searchInRotatedArray(nums, key, left, mid - 1);
            } else {
                return searchInRotatedArray(nums, key, mid + 1, right);
            }
        } else {
            if (nums[mid] <= key && key <= nums[right]) {
                return searchInRotatedArray(nums, key, mid + 1, right);
            } else {
                return searchInRotatedArray(nums, key, left, mid - 1);
            }
        }
    }
}

// way 3

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}