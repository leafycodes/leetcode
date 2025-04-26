class Solution {
    public int minimumPairRemoval(int[] nums) {
        int operations=0;

        while(!isSorted(nums)){
            int minIndex=-1;
            for(int i=0;i<nums.length-1;i++){
                if(minIndex==-1 || nums[i]+ nums[i+1]<nums[minIndex]+ nums[minIndex+1]){
                    minIndex =i;
                }
            }
            nums=merge(nums,minIndex);
            operations++;
        }
        return operations;
    }

    private boolean isSorted(int[] nums){
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                return false;
            }
        }
        return true;
    }

    private int[] merge(int[] nums, int index){
        int[] newNums = new int[nums.length-1];
        for(int i=0,j=0;i<nums.length;i++){
            if(i==index){
                newNums[j++]=nums[i]+nums[i+1];
                i++;
            }else{
                newNums[j++]=nums[i];
            }
        }
        return newNums;
    }

}