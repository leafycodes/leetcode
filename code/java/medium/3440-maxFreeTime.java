class Solution {
    public int maxFreeTime(int totalEventTime, int[] startTimes, int[] endTimes) {
        int[] freeGaps = new int[startTimes.length + 1];
        freeGaps[0] = startTimes[0];
        for (int i = 1; i < startTimes.length; i++) {
            freeGaps[i] = startTimes[i] - endTimes[i - 1];
        }
        freeGaps[startTimes.length] = totalEventTime - endTimes[endTimes.length - 1];

        int[] maxRightGaps = new int[freeGaps.length];
        for (int i = freeGaps.length - 2; i >= 0; i--) {
            maxRightGaps[i] = Math.max(maxRightGaps[i + 1], freeGaps[i + 1]);
        }

        int maxFreeTime = 0, maxLeftGap = 0;
        for (int i = 1; i < freeGaps.length; i++) {
            int currentDuration = endTimes[i - 1] - startTimes[i - 1];
            if (currentDuration <= Math.max(maxLeftGap, maxRightGaps[i])) {
                maxFreeTime = Math.max(maxFreeTime, freeGaps[i - 1] + freeGaps[i] + currentDuration);
            }
            maxFreeTime = Math.max(maxFreeTime, freeGaps[i - 1] + freeGaps[i]);
            maxLeftGap = Math.max(maxLeftGap, freeGaps[i - 1]);
        }
        return maxFreeTime;
    }
}

// help from solutions - Sumit Kumar