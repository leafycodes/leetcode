class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int count : freq.values()) {
            if (count % 2 == 1) {
                if (count > maxOdd) {
                    maxOdd = count;
                }
            } else {
                if (count < minEven) {
                    minEven = count;
                }
            }
        }

        if (maxOdd == Integer.MIN_VALUE || minEven == Integer.MAX_VALUE) {
            return 0;
        }

        return maxOdd - minEven;
    }
}