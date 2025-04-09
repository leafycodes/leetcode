class Solution {
    public int minOperations(int[] nums, int k) {
        for(int num:nums){
            if(num<k){
                return -1;
            }
        }

        Set<Integer> greaterThanK=new HashSet<>();
        for(int num: nums){
            if(num>k){
                greaterThanK.add(num);
            }
        }

        return greaterThanK.size();
    }
}