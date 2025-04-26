class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);
        long result = 0, count = 0;

        for (int num : nums) {
            if (num % modulo == k) count++;
            int key = (int)((count - k) % modulo + modulo) % modulo;
            result += map.getOrDefault(key, 0L);
            int modCount = (int)(count % modulo);
            map.put(modCount, map.getOrDefault(modCount, 0L) + 1);
        }

        return result;
    }
}