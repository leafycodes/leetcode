class TreeAncestor {
    private int[][] up;
    private int maxPower;

    public TreeAncestor(int n, int[] parent) {
        this.maxPower = (int) (Math.log(n) / Math.log(2)) + 1;
        this.up = new int[n][maxPower];

        for (int node = 0; node < n; node++) {
            up[node][0] = parent[node];
        }

        for (int power = 1; power < maxPower; power++) {
            for (int node = 0; node < n; node++) {
                int prevAncestor = up[node][power - 1];
                up[node][power] = prevAncestor == -1 ? -1 : up[prevAncestor][power - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int power = 0; power < maxPower; power++) {
            if ((k & (1 << power)) != 0) {
                node = up[node][power];
                if (node == -1) {
                    return -1;
                }
            }
        }
        return node;
    }
}
/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */