class Solution {
    public int minimumCardPickup(int[] cards) {
        int[] right=new int[1000001];
        Arrays.fill(right,-1);
        int res=Integer.MAX_VALUE;

        for(int i=0;i<cards.length;i++){
            if(right[cards[i]]!=-1){
                res=Math.min(i-right[cards[i]]+1,res);
            }
            right[cards[i]]=i;
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}