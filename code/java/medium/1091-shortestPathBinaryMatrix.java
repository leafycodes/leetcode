class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;

        if(grid[0][0] !=0 || grid[n-1][n-1]!=0){
            return -1;
        }

        int[][] directions={
            {0,1},{1,0},{1,1},{0,-1},{-1,0},{-1,-1},{1,-1},{-1,1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});

        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int r=current[0],c=current[1], pathLen=current[2];

            if(r==n-1 && c==n-1){
                return pathLen;
            }

            for(int[] dir: directions){
                int newRow=r+dir[0];
                int newCol=c+dir[1];

                if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==0){
                    queue.offer(new int[]{newRow,newCol,pathLen+1});
                    grid[newRow][newCol]=1;
                }
            }
        }
        return -1;
    }
}