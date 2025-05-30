class Solution {
    private int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<List<Integer>> tree = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            tree.get(u).add(v);
            tree.get(v).add(u);

        }

        int[] parent = new int[n + 1];

        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        parent[1] = 0;

        int farthest = 1;
        while (!q.isEmpty()) {
            farthest = q.poll();
            for (int neighbor : tree.get(farthest)) {
                if (parent[neighbor] == -1 && neighbor != parent[farthest]) {
                    parent[neighbor] = farthest;
                    q.add(neighbor);
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int node = farthest;
        while (node != 0) {
            path.add(node);
            node = parent[node];
        }
        Collections.reverse(path);

        int pathEdges = path.size() - 1;
        if (pathEdges == 0) {
            return 0;
        }

        long ways = 1;
        for (int i = 1; i < pathEdges; i++) {
            ways = (ways * 2) % MOD;
        }

        return (int) ways;
    }
}