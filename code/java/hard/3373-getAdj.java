class Solution {

    public Map<Integer, List<Integer>> getAdj(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    private void dfs(int curr, Map<Integer, List<Integer>> adj, int parent,
                     int[] mark, int[] count) {
        if (mark[curr] == 0) {
            count[0]++;
        } else {
            count[1]++;
        }

        for (int neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
            if (neighbor != parent) {
                mark[neighbor] = (mark[curr] == 0) ? 1 : 0;
                dfs(neighbor, adj, curr, mark, count);
            }
        }
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int N = edges1.length + 1; 
        int M = edges2.length + 1; 

        Map<Integer, List<Integer>> adjA = getAdj(edges1);
        Map<Integer, List<Integer>> adjB = getAdj(edges2);

        int[] markA = new int[N];
        Arrays.fill(markA, -1);
        markA[0] = 0;
        int[] countA = new int[2];

        dfs(0, adjA, -1, markA, countA);

        int[] markB = new int[M];
        Arrays.fill(markB, -1);
        markB[0] = 0;
        int[] countB = new int[2];
        dfs(0, adjB, -1, markB, countB);

        int maxFromTree2 = Math.max(countB[0], countB[1]);

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = (markA[i] == 0 ? countA[0] : countA[1]) + maxFromTree2;
        }

        return result;
    }
}

//help from the king: CODESTORYWITHMIK