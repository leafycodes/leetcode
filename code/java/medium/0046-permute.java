class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        findPermutations(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void findPermutations(int[] nums, List<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (!used[j]) {
                used[j] = true;
                current.add(nums[j]);
                findPermutations(nums, current, used);
                current.remove(current.size() - 1);
                used[j] = false;
            }
        }
    }
}