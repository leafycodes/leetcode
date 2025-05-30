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

//way 2

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(j!=i && (nums[i]-target==(-nums[j]))){
                    return new int[]{i,j};
                }
            }
        }
        return new int[2];
    }
}