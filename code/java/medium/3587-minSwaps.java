class Solution {
    public int minSwaps(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int n = nums.length;
        int evenCount = 0;
        int oddCount = 0;

        for (int num : nums) {
            if ((num & 1) == 1) {
                oddCount++;
            } else {
                evenCount++;
            }
        }

        if (Math.abs(evenCount - oddCount) > 1) {
            return -1;
        }

        long swapsIfEvenAt0 = Long.MAX_VALUE;
        long swapsIfOddAt0 = Long.MAX_VALUE;

        if (evenCount >= oddCount) {
            swapsIfEvenAt0 = findSwaps(nums, true);
        }

        if (oddCount >= evenCount) {
            swapsIfOddAt0 = findSwaps(nums, false);
        }

        return (int) Math.min(swapsIfOddAt0, swapsIfEvenAt0);
    }

    private long findSwaps(int[] nums, boolean evenAt0) {
        long currSwaps = 0;
        int keyPos = 0;

        if (evenAt0) {
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & 1) == 0) {
                    currSwaps += Math.abs(i - keyPos);
                    keyPos += 2;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & 1) == 1) {
                    currSwaps += Math.abs(i - keyPos);
                    keyPos += 2;
                }
            }
        }
        return currSwaps;
    }
}