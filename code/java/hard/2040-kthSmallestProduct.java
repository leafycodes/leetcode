class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = (long) -1e11;
        long right = (long) 1e11;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (countLessOrEqual(nums1, nums2, mid) >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private long countLessOrEqual(int[] nums1, int[] nums2, long target) {
        long count = 0;
        for (int num1 : nums1) {
            if (num1 == 0) {
                if (target >= 0) {
                    count += nums2.length;
                }
            } else if (num1 > 0) {
                long boundaryValueForNum2 = target / num1;
                if (target < 0 && target % num1 != 0) {
                    boundaryValueForNum2--;
                }
                count += upperBound(nums2, boundaryValueForNum2);
            } else {
                long boundaryValueForNum2 = target / num1;
                if (target < 0 && target % num1 != 0) {
                    boundaryValueForNum2++;
                }
                count += nums2.length - lowerBound(nums2, boundaryValueForNum2);
            }
        }
        return count;
    }

    private int upperBound(int[] nums, long target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int lowerBound(int[] nums, long target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// the online gods helped me