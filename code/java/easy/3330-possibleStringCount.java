class Solution {
    public int possibleStringCount(String word) {
        int sum = 0;
        int n = word.length();

        for (int i = 0; i < n; ) {
            char current = word.charAt(i);
            int j = i;
            while (j < n && word.charAt(j) == current) {
                j++;
            }
            int len = j - i;
            if (len >= 2) {
                sum += len - 1;
            }
            i = j;
        }
        
        return sum + 1;
    }
}