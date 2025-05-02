class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<List<Integer>> set=new HashSet<>();
        int count=0;
            
        for(int i=0;i<nums.length;i++){
            List<Integer> lint=new ArrayList<>();
            for(int j=i;j<nums.length;j++){
                if(nums[j]%p==0)count++;
                if(count>k)break;

                lint.add(nums[j]);
                set.add(new ArrayList<>(lint));
            }
            count=0;
        }
        return set.size();
    }
}