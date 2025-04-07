class Solution {
    public boolean isMonotonic(int[] nums) {
        if(monoDec(nums)||monoInc(nums)){
            return true;
        }
        return false;
    }
    public boolean monoDec(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                return false;
            }
        }
        return true;
    }
    public boolean monoInc(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }
}