class Solution {
    class DSU {
        int[] parent;

        public DSU() {
            parent = new int[26];
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rootX < rootY) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootX] = rootY;
                }
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DSU dsu = new DSU();

        for (int i = 0; i < s1.length(); i++) {
            dsu.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char originalChar = baseStr.charAt(i);
            char equivalentChar = (char) ('a' + dsu.find(originalChar - 'a'));
            result.append(equivalentChar);
        }

        return result.toString();
    }
}