class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, left = 0, right = 0;

        while (right < n) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                ans = Math.max(ans, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return ans;
    }
}