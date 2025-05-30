class Solution {
    public int[] buildArray(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]+nums.length*(nums[nums[i]]%nums.length);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]/=nums.length;
        }
        return nums;
    }
}

//way 2

class Solution {
    public int[] buildArray(int[] nums) {
        int[] res=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            res[i]=nums[nums[i]];
        }
        return res;
    }
}