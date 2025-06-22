class Solution {
    public int maxDiff(int num) {
        int max = num, min = num;
        String numStr = String.valueOf(num);

        int i = 0;
        boolean firstNumIsOne = numStr.charAt(0) == '1';
        while (i < numStr.length()) {
            if (numStr.charAt(i) == '9') {
                i++;
            } else {
                max = Integer.valueOf(numStr.replace(numStr.charAt(i), '9'));
                break;
            }
        }

        i = 0;
        while (i < numStr.length()) {
            if (firstNumIsOne) {
                if (numStr.charAt(i) == '0' || numStr.charAt(i) == '1') {
                    i++;
                } else {
                    min = Integer.valueOf(numStr.replace(numStr.charAt(i), '0'));
                    break;
                }
            } else {
                min = Integer.valueOf(numStr.replace(numStr.charAt(i), '1'));
                break;
            }
        }
        return max - min;
    }
}