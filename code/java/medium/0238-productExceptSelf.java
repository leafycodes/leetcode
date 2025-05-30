
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        for (int i = 1; i < n - 1; i++) {
            nums[i] = prefix[i - 1] * suffix[i + 1];
        }

        nums[0] = suffix[1];
        nums[n - 1] = prefix[n - 2];

        return nums;
    }
}

//way 2

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, product = 1, zeroCount = 0;
        int[] result = new int[n];

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }

        if (zeroCount > 1) {
            for (int i = 0; i < n; i++) {
                result[i] = 0;
            }
        } else if (zeroCount == 1) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    result[i] = product;
                } else {
                    result[i] = 0;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                result[i] = product / nums[i];
            }
        }

        return result;
    }
}