class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            available.offer(i);
        }
        int[] count = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                int[] freed = busy.poll();
                available.offer(freed[1]);
            }

            if (!available.isEmpty()) {
                int room = available.poll();
                count[room]++;
                busy.offer(new int[] { end, room });
            } else {
                int[] freed = busy.poll();
                int room = freed[1];
                count[room]++;
                int newEnd = freed[0] + (end - start);
                busy.offer(new int[] { newEnd, room });
            }
        }

        int maxRoom = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > count[maxRoom]) {
                maxRoom = i;
            }
        }
        return maxRoom;
    }
}