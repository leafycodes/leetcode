class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<List<Integer>> tree1 = buildTree(edges1, n);
        List<List<Integer>> tree2 = buildTree(edges2, m);
        
        int[][] dist1 = new int[n][n];
        for (int u = 0; u < n; u++) {
            bfs(u, tree1, dist1[u]);
        }
        
        int[][] dist2 = new int[m][m];
        for (int u = 0; u < m; u++) {
            bfs(u, tree2, dist2[u]);
        }
        
        int[] count2 = new int[m];
        for (int v = 0; v < m; v++) {
            int cnt = 0;
            for (int u = 0; u < m; u++) {
                if (dist2[v][u] <= (k - 1)) {
                    cnt++;
                }
            }
            count2[v] = cnt;
        }
        int maxInTree2 = 0;
        for (int cnt : count2) {
            if (cnt > maxInTree2) {
                maxInTree2 = cnt;
            }
        }
        
        int[] count1 = new int[n];
        for (int u = 0; u < n; u++) {
            int cnt = 0;
            for (int v = 0; v < n; v++) {
                if (dist1[u][v] <= k) {
                    cnt++;
                }
            }
            count1[u] = cnt;
        }
        
        int[] answer = new int[n];
        for (int u = 0; u < n; u++) {
            answer[u] = count1[u] + maxInTree2;
        }
        
        return answer;
    }
    
    private List<List<Integer>> buildTree(int[][] edges, int nodeCount) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        return tree;
    }
    
    private void bfs(int start, List<List<Integer>> tree, int[] distances) {
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        distances[start] = 0;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : tree.get(u)) {
                if (distances[v] == -1) {
                    distances[v] = distances[u] + 1;
                    queue.offer(v);
                }
            }
        }
    }
}

//help from online sources