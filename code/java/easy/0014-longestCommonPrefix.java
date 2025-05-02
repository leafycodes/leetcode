class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);
        String left = strs[0];
        String right = strs[strs.length - 1];

        int length = Math.min(left.length(), right.length());
        String res = "";

        for (int i = 0; i < length; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                break;
            }
            res += left.charAt(i);
        }
        return res;
    }
}