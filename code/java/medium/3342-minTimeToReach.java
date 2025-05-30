class Solution {

    private int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] res = new int[n][m];
        for (int[] row : res) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        res[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        pq.add(new int[] { 0, 0, 0 });
        boolean[][] visited = new boolean[n][m];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int j = curr[1], k = curr[2];

            if (visited[j][k]) {
                continue;
            }
            visited[j][k] = true;

            for (int[] dir : directions) {
                int nx = j + dir[0], ny = k + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int wait = Math.max(time, moveTime[nx][ny]);
                    int now=wait+1;
                    if((nx+ny)%2==0){
                        now++;
                    }

                    if (res[nx][ny] > now) {
                        res[nx][ny] = now;
                        pq.add(new int[] { now, nx, ny });
                    }
                }
            }
        }
        return res[n - 1][m - 1];
    }
}