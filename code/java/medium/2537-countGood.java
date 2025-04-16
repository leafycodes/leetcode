class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long res = 0;
        long count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            int prev = freq.getOrDefault(val, 0);
            count += prev; 
            freq.put(val, prev + 1);

            while (count >= k) {
                res += nums.length - right;
                int leftVal = nums[left];
                int prevLeft = freq.get(leftVal);
                count -= (prevLeft - 1); 
                freq.put(leftVal, prevLeft - 1);
                left++;
            }
        }

        return res;
    }
}