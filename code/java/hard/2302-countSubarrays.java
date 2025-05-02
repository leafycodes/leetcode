class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n=nums.length;
        long count=0;
        long sum=0;
        int start=0;

        for(int end=0;end<n;end++){
            sum+=nums[end];

            while(sum*(end-start+1)>=k){
                sum-=nums[start];
                start++;
            }

            count+=(end-start+1);
        }
        return count;
    }
}