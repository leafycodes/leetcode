class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sumNums1 = 0, sumNums2 = 0;
        int countZeroesNums1 = 0, countZeroesNums2 = 0;

        for (int num : nums1) {
            sumNums1 += num;
            if (num == 0) {
                countZeroesNums1++;
                sumNums1 += 1;
            }
        }

        for (int num : nums2) {
            sumNums2 += num;
            if (num == 0) {
                countZeroesNums2++;
                sumNums2 += 1;
            }
        }

        if (sumNums1 == sumNums2) {
            return sumNums1;
        } else if (sumNums1 > sumNums2) {
            if (countZeroesNums2 != 0) {
                return sumNums1;
            } else {
                return -1;
            }
        } else {
            if (countZeroesNums1 != 0) {
                return sumNums2;
            } else {
                return -1;
            }
        }
    }
}