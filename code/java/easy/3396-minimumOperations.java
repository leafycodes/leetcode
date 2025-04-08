class Solution {
    public int minimumOperations(int[] nums) {
        return tempHelp(nums,0);
    }

    public int tempHelp(int[] nums,int ops){
        Set<Integer> set=new HashSet<>();

        boolean distinct=true;
        for(int num:nums){
            if(!set.add(num)){
                distinct=false;
                break;
            }
        }
        if(distinct){
            return ops;
        }

        int size=Math.max(0,nums.length-3);
        int[] arr=new int[size];
        for(int i=3;i<nums.length;i++){
            arr[i-3]=nums[i];
        }

        return tempHelp(arr,ops+1);
    }    
}