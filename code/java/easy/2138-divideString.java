class Solution {
    public String[] divideString(String s, int k, char fill) {
        StringBuilder currStr = new StringBuilder(s);

        int rem = s.length() % k;
        if (rem != 0) {
            for (int i = 0; i < k - rem; i++) {
                currStr.append(fill);
            }
        }

        String res[] = new String[currStr.length() / k];
        for (int i = 0, j = 0; i < currStr.length(); i += k,
                j++) {
            res[j] = currStr.substring(i, i + k);
        }

        return res;
    }
} 