class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]=new int[2];
        for(int idx=0;idx<nums.length;idx++){
            for(int jdx=idx+1;jdx<nums.length;jdx++){
                if(nums[jdx]+nums[idx]==target){
                    ans[0]=jdx;
                    ans[1]=idx;
                }
            }
        }
        return ans;
    }
}