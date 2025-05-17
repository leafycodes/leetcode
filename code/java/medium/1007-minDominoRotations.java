class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res=Integer.MAX_VALUE;
        for(int i=1;i<=6;i++){
            int eachDice=possibleMove(tops,bottoms,i);

            if(eachDice!=-1){
                res=Math.min(eachDice,res);
            }
        }
        return res == Integer.MAX_VALUE?-1:res;
    }
    private int possibleMove(int[] tops, int[] bottoms, int target){
        int sTop=0,sBot=0;
        
        for(int i=0;i<tops.length;i++){
            if(tops[i]!=target && bottoms[i]!=target){
                return -1;
            }else if(tops[i]!=target){
                sTop++;
            }else if(bottoms[i]!=target){
                sBot++;
            }
        }
        return Math.min(sTop, sBot);
    }
}