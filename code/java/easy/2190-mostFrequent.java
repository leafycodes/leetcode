class Solution {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                int nextNum = nums[i + 1];
                frequencyMap.put(nextNum, frequencyMap.getOrDefault(nextNum, 0) + 1);
            }
        }

        int maxFrequency = Integer.MIN_VALUE;
        int mostFrequentNum = -1;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentNum = entry.getKey();
            }
        }

        return mostFrequentNum;
    }
}