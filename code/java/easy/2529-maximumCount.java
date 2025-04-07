class Solution {
    public int maximumCount(int[] nums) {
        int neg=0;
        int pos=0;
        for(int i:nums){
            if(i==0){
                continue;
            }
            else if(i<0){
                neg++;
            }
            else{
                pos++;
            }
        }
        return (pos>=neg)?pos:neg;
    }
}