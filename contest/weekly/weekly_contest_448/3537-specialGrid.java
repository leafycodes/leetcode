class Solution {
    public int[][] specialGrid(int N) {
        int size=1<<N;
        int[][] grid=new int[size][size];
        fill(grid,0,0,size,0);
        return grid;
    }

    private void fill(int[][] grid,int row,int col,int size,int start){
        if(size==1){
            grid[row][col]=start;
            return;
        }
        int half=size/2;
        int block=half*half;

        fill(grid,row,col+half,half,start);
        fill(grid,row+half,col+half,half,start+block);
        fill(grid,row+half,col,half,start+2*block);
        fill(grid,row,col,half,start+3*block);
        
    }
}