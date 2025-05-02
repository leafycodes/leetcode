class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long total = 0;
        int negCount = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                total += Math.abs(val);
                if (val < 0) {
                    negCount++;
                }
                minAbs = Math.min(minAbs, Math.abs(val));
            }
        }
        if(negCount % 2 == 0) {
            return total;
        } else {
            return total - 2 * minAbs;
        }
    }
}