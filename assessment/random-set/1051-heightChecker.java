class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        expected = heights.clone();
        Arrays.sort(expected);
        
        int count=0;
        for(int i=0; i<heights.length;i++){
            if(expected[i]!=heights[i]){
                ++count;
            }
        }
        
        return count;
    }
}