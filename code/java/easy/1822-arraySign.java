class Solution {
    public int arraySign(int[] nums) {
        float product=1;
        for(int idx=0;idx<nums.length;idx++){
            product*=nums[idx];
        }
        if(product>0){
            return 1;
        }
        else if(product<0){
            return -1;
        }
        else return 0;
    }
}