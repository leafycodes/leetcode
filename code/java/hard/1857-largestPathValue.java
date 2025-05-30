class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[][] dp = new int[n][26];
        int nodesProcessed = 0;
        int maxColorValue = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            nodesProcessed++;
            dp[u][colors.charAt(u) - 'a']++;
            maxColorValue = Math.max(maxColorValue, dp[u][colors.charAt(u) - 'a']);
            for (int v : adj.get(u)) {
                for (int c = 0; c < 26; c++) {
                    dp[v][c] = Math.max(dp[v][c], dp[u][c]);
                }
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (nodesProcessed != n) {
            return -1;
        }
        return maxColorValue;
    }
}

//help from online sources