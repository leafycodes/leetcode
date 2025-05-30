class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;
        int alteredCount = 0;
        long minPositiveChange = Long.MAX_VALUE;
        long maxNegativeChange = Long.MIN_VALUE;

        for (int value : nums) {
            long xorValue = (long) value ^ k;
            long currentChange = xorValue - value;

            totalSum += value;

            if (currentChange > 0) {
                totalSum += currentChange;
                alteredCount++;
                minPositiveChange = Math.min(minPositiveChange, currentChange);
            } else {
                maxNegativeChange = Math.max(maxNegativeChange, currentChange);
            }
        }

        if (alteredCount % 2 == 0) {
            return totalSum;
        } else {
            long adjustmentCost;

            boolean hasPositiveChanges = (minPositiveChange != Long.MAX_VALUE);
            boolean hasNegativeOrZeroChanges = (maxNegativeChange != Long.MIN_VALUE);

            if (hasPositiveChanges && hasNegativeOrZeroChanges) {
                adjustmentCost = Math.min(minPositiveChange, -maxNegativeChange);
            } else if (hasPositiveChanges) {
                adjustmentCost = minPositiveChange;
            } else {
                if (maxNegativeChange == Long.MIN_VALUE) {
                    adjustmentCost = minPositiveChange;
                } else {
                    adjustmentCost = Math.min(minPositiveChange, -maxNegativeChange);
                }
            }
            return totalSum - adjustmentCost;
        }
    }
}

//took help from online sources