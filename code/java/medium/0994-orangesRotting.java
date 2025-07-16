class Solution {
    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                Pair curr = q.remove();
                
                for(int[] dir : directions) {
                    int newX = curr.x + dir[0];
                    int newY = curr.y + dir[1];
                    
                    if(newX >= 0 && newX < grid.length && 
                       newY >= 0 && newY < grid[0].length && 
                       grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        q.add(new Pair(newX, newY));
                        fresh--;
                    }
                }
            }
            
            if(!q.isEmpty()) time++;
        }
        
        return fresh == 0 ? time : -1;
    }
}