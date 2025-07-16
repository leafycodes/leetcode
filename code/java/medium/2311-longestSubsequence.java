class Solution {
    public int longestSubsequence(String s, int k) {
        int value = 0;
        int length = 0;
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                length++;
            } else {
                if (length < 30 && value + (1 << length) <= k) {
                    value += (1 << length);
                    length++;
                }
            }
        }

        return length;
    }
}