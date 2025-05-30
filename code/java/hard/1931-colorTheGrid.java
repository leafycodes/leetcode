class Solution {
    private List<String> colStates = new ArrayList<>();
    private int[][] memo;
    private int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        genColStates("", m, '#');

        int numColPatterns = colStates.size();
        memo = new int[n][numColPatterns];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int res = 0;
        for (int i = 0; i < numColPatterns; i++) {
            res = (res + solve(n - 1, i, m)) % MOD;
        }

        return res;
    }

    private void genColStates(String currCol, int remainingRows, char prev) {
        if (remainingRows == 0) {
            colStates.add(currCol);
            return;
        }
        for (char color : new char[] { 'R', 'G', 'B' }) {
            if (color == prev) {
                continue;
            }
            genColStates(currCol + color, remainingRows - 1, color);
        }
    }

    private int solve(int remainingCols, int prev, int m) {
        if (remainingCols == 0) {
            return 1;
        }
        if (memo[remainingCols][prev] != -1) {
            return memo[remainingCols][prev];
        }

        int ways = 0;
        String prevCol = colStates.get(prev);

        for (int nextCol = 0; nextCol < colStates.size(); nextCol++) {
            String nextColumn = colStates.get(nextCol);
            boolean valid = true;

            for (int r = 0; r < m; r++) {
                if (prevCol.charAt(r) == nextColumn.charAt(r)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ways = (ways + solve(remainingCols - 1, nextCol, m)) % MOD;
            }
        }

        return memo[remainingCols][prev] = ways;
    }
}

//help form codestorywithMIK youtube channel