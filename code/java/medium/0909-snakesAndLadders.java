class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        boolean[][] visited = new boolean[n][n];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[n - 1][0] = true;

        int diceRolls = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int curr = queue.poll();

                if (curr == n * n) {
                    return diceRolls;
                }

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) {
                        break;
                    }

                    int matrixPosition[] = getCoordinates(next, n);
                    int row = matrixPosition[0];
                    int col = matrixPosition[1];

                    if (visited[row][col]) {
                        continue;
                    }

                    visited[row][col] = true;

                    if (board[row][col] == -1) {
                        queue.offer(next);
                    } else {
                        queue.offer(board[row][col]);
                    }
                }
            }
            diceRolls++;

        }

        return -1;
    }

    private int[] getCoordinates(int num, int n) {
        int rowFromTop = (num - 1) / n;
        int rowFromBottom = n - 1 - rowFromTop;

        int colFromLeft = (num - 1) % n;

        if ((n % 2 == 0 && rowFromBottom % 2 == 0) || (n % 2 != 0 && rowFromBottom % 2 != 0)) {
            colFromLeft = n - 1 - colFromLeft;
        }

        return new int[] { rowFromBottom, colFromLeft };
    }
}