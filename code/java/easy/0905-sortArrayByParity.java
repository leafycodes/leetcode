class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int eidx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                int temp=nums[i];
                nums[i]=nums[eidx];
                nums[eidx]=temp;
                eidx++;
            }
        }
        return nums;
    }
}