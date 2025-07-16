class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;

        List<Integer> allGaps = new ArrayList<>();

        allGaps.add(startTime[0]);

        for (int i = 0; i < n - 1; i++) {
            allGaps.add(startTime[i + 1] - endTime[i]);
        }

        allGaps.add(eventTime - endTime[n - 1]);

        int maxFreeTime = 0;
        long currentSum = 0;
        int left = 0;

        int windowSizeLimit = k + 1;

        for (int right = 0; right < allGaps.size(); right++) {
            currentSum += allGaps.get(right);

            while ((right - left + 1) > windowSizeLimit) {
                currentSum -= allGaps.get(left);
                left++;
            }

            maxFreeTime = (int) Math.max(maxFreeTime, currentSum);
        }

        return maxFreeTime;
    }
}