class Solution {
    private int MOD=1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {
        int[] freq=new int[26];

        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        for(int count=0;count<t;count++){
            int[] temp=new int[26];
            for(int i=0;i<26;i++){
                int currCount=freq[i];
                if(i==25){
                    temp[0]=(temp[0]+currCount)%MOD;
                    temp[1]=(temp[1]+currCount)%MOD;
                }else{
                    temp[i+1]=(temp[i+1]+currCount)%MOD;
                }
            }
            freq=temp;
        }
        int res=0;
        for(int num:freq){
            res=(res+num)%MOD;
        }
        return res;
    }
}