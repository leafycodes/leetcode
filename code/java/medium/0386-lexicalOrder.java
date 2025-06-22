class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        Collections.sort(nums, (a, b) -> String.valueOf(a).compareTo(String.valueOf(b)));
        return nums;
    }
}

// way 2

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> nums = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            nums.add(String.valueOf(i));
        }

        Collections.sort(nums);
        
        List<Integer> res = new ArrayList<>();
        for (String str : nums) {
            res.add(Integer.parseInt(str));
        }

        return res;
    }
}