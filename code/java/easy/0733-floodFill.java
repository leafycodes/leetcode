// LGSI interview question

class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public boolean isValid(int[][] image, int row, int col, int color) {
        return row >= 0 && row < image.length && col >= 0 && col < image[0].length && image[row][col] == color;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //add pixel to queue

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        //add adjacent pixel if they're same
        while (!q.isEmpty()) {
            Pair curr = q.remove();

            if (image[curr.row][curr.col] == color) {
                continue;
            }
            int temp = image[curr.row][curr.col];
            image[curr.row][curr.col] = color;
            //case: not first time we encounter this pixel
            

            for (int[] dir : directions) {
                int dx = curr.row + dir[0];
                int dy = curr.col + dir[1];

                //add if its valid
                if (isValid(image, dx, dy, temp)) {
                    q.add(new Pair(dx, dy));
                }
            }

        }

        return image;
    }
}