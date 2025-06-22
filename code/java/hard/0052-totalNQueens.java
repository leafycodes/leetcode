class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2 || n == 3) {
            return 0;
        }
        solve(new int[n], 0);
        return count;
    }

    private void solve(int[] queens, int row) {
        if (row == queens.length) {
            count++;
            return;
        }

        for (int col = 0; col < queens.length; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                solve(queens, row + 1);
            }
        }
    }

    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col ||
                    Math.abs(row - i) == Math.abs(col - queens[i])) {
                return false;
            }
        }
        return true;
    }
}