class Solution {
    public static boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;
        for (int[] row : grid) {
            for (int val : row) {
                total += val;
            }
        }

        if (total % 2 != 0) return false;
        long half = total / 2;

        long topSum = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                topSum += grid[i][j];
            }
            if (topSum == half) return true;
        }

        long[] colSums = new long[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colSums[j] += grid[i][j];
            }
        }

        long leftSum = 0;
        for (int j = 0; j < n - 1; j++) { 
            leftSum += colSums[j];
            if (leftSum == half) return true;
        }

        return false;
    }
}