class Solution {
    public int maxEvents(int[][] events) {
        if (events == null || events.length == 0) {
            return 0;
        }

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int maxEvents = 0;
        int i = 0;
        int n = events.length;
        int currentDay = 0;

        while (!minHeap.isEmpty() || i < n) {
            if (minHeap.isEmpty()) {
                currentDay = events[i][0];
            }

            while (i < n && events[i][0] <= currentDay) {
                minHeap.offer(events[i][1]);
                i++;
            }

            minHeap.poll();
            maxEvents++;
            currentDay++;

            while (!minHeap.isEmpty() && minHeap.peek() < currentDay) {
                minHeap.poll();
            }
        }

        return maxEvents;
    }
}