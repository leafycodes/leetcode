class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) {
            return 1;
        }

        int[] leftToRight = new int[n];
        Arrays.fill(leftToRight, 0);

        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                leftToRight[i] = leftToRight[i - 1] + 1;
            }
        }

        int[] rightToLeft = new int[n];
        Arrays.fill(rightToLeft, 0);

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            }
        }

        int[] candies = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            candies[i] = Math.max(rightToLeft[i], leftToRight[i]);
            sum += candies[i];
        }

        return sum + n;
    }
}