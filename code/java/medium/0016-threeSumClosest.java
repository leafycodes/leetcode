class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum=nums[0]+nums[1]+nums[2];

        for(int i=0;i<nums.length-2;i++){
            int left=i+1,right=nums.length-1;

            while(left<right){
                int curr=nums[i]+nums[left]+nums[right];

                if(Math.abs(curr-target)<Math.abs(sum-target)){
                    sum=curr;
                }

                if(curr<target){
                    left++;
                }else if(curr>target){
                    right--;
                }else{
                    return curr;
                }
            }
        }
        return sum;
    }
}