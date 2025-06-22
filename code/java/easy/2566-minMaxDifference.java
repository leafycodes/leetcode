class Solution {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        int max = num, min = num;
        int i = 0;

        while (i < numStr.length()) {
            if (numStr.charAt(i) == '9') {
                i++;
            } else {
                String maxStr = numStr.replace(numStr.charAt(i), '9');
                max = Integer.valueOf(maxStr);
                break;
            }
        }

        i = 0;
        while (i < numStr.length()) {
            if (numStr.charAt(i) == '0') {
                i++;
            } else {
                String minStr = numStr.replace(numStr.charAt(i), '0');
                min = Integer.valueOf(minStr);
                break;
            }
        }

        return max - min;
    }
}