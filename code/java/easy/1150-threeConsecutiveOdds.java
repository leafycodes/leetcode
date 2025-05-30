class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count=0;

        for (int i: arr ) {
            if((i & 1)==1){
                count++;
                if(count==3){
                    return true;
                }
            }else{
                count=0;
            }
        }
        return false;
    }
}