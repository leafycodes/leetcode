class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}

//way 2

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {

        if(nums.length<3){
            return res;
        }

        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            twoSum(nums,-nums[i],i+1,nums.length-1);
        }

        return res;
    }
    private void twoSum(int[] nums,int target,int i,int j){
        while(i<j){
            if(nums[i]+nums[j]==target){
                List<Integer> triplet=new ArrayList<>();
                triplet.add(-target);
                triplet.add(nums[i]);
                triplet.add(nums[j]);
                res.add(triplet);
                i++;
                j--;

                while(i<j && nums[i]==nums[i-1]){
                    i++;
                }
                while(i<j && nums[j]==nums[j+1]){
                    j--;
                }
            }else if(nums[i]+nums[j]<target){
                i++;
            }else{
                j--;
            }
        }
    }
}