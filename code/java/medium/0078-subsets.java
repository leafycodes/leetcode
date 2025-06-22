class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, new ArrayList<>(), 0);
        return res;
    }

    private void helper(int[] nums, List<Integer> ans, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        helper(nums, ans, i + 1);
        ans.add(nums[i]);
        helper(nums, ans, i + 1);
        ans.remove(ans.size() - 1);
    }
}