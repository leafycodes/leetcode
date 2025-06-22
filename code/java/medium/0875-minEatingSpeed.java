class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int leftBoundOfK = 1;
        int rightBoundOfK = Integer.MIN_VALUE;
        for (int pile : piles) {
            rightBoundOfK = Math.max(rightBoundOfK, pile);
        }

        while (leftBoundOfK < rightBoundOfK) {
            int midBoundOfK = leftBoundOfK + (rightBoundOfK - leftBoundOfK) / 2;
            if (kokoCanEatAll(piles, midBoundOfK, h)) {
                rightBoundOfK = midBoundOfK;
            } else {
                leftBoundOfK = midBoundOfK + 1;
            }
        }
        return rightBoundOfK;
    }

    private boolean kokoCanEatAll(int[] piles, int k,
            int h) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += Math.ceil((double) pile / k);
            if (totalHours > h) {
                return false;
            }
        }
        return true;
    }
}