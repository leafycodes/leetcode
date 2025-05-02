class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }

        int left=0,count=0;
        long result=0;
        for(int right=0;right<n;right++){
            if(nums[right]==max) count++;

            while(count>=k){
                if(nums[left]==max) count--;
                left++;
            }
            result+=left;
        }
        return result;
    }
}