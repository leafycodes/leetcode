class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }

        int[] dp = new int[words.length], prev = new int[words.length];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLength = 1, maxIndex = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && words[i].length() == words[j].length()
                        && distance(words[i], words[j]) == 1) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxIndex = i;
            }
        }

        int i = maxIndex;
        while (i != -1) {
            res.add(words[i]);
            i = prev[i];
        }
        Collections.reverse(res);
        return res;

    }

    private int distance(String a, String b) {
        int d = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                d++;

            }
        }
        return d;
    }
}