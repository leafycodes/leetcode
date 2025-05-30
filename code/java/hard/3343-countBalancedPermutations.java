class Solution {
    private int n;
    private int totalDigitSum = 0;
    private int MOD = 1_000_000_007;
    private long totalPermutationsPossible = 0;

    private long power(long a, long b) {
        if (b == 0) {
            return 1;
        }

        long half = power(a, b / 2);
        long res = (half * half) % MOD;

        if (b % 2 == 1) {
            res = (res * a) % MOD;
        }

        return res;
    }

    private long solve(int digit, int evenIndexDigitsCount, int sum, int[] freq, long[] fermatFactorial, long[][][] t) {
        if (digit == 10) {
            if (sum == totalDigitSum / 2 && evenIndexDigitsCount == (n + 1) / 2) {
                return totalPermutationsPossible;
            }
            return 0;
        }
        if (t[digit][evenIndexDigitsCount][sum] != -1) {
            return t[digit][evenIndexDigitsCount][sum];
        }

        long ways = 0;

        for (int count = 0; count <= Math.min(freq[digit], (n + 1) / 2 - evenIndexDigitsCount); count++) {
            int evenPosCount = count;
            int oddPosCount = freq[digit] - count;

            long div = (fermatFactorial[evenPosCount] * fermatFactorial[oddPosCount]) % MOD;
            long val = solve(digit + 1, evenIndexDigitsCount + evenPosCount, sum + digit * evenPosCount, freq,
                    fermatFactorial, t);
            ways = (ways + (val * div) % MOD) % MOD;
        }
        return t[digit][evenIndexDigitsCount][sum] = ways;
    }

    public int countBalancedPermutations(String num) {
        n = num.length();

        int[] freq = new int[10];
        Arrays.fill(freq, 0);

        for (int i = 0; i < n; i++) {
            int d = num.charAt(i) - '0';
            totalDigitSum += d;
            freq[d]++;
        }

        if (totalDigitSum % 2 != 0) {
            return 0;
        }

        long[] factorial = new long[n + 1];
        Arrays.fill(factorial, 1);
        factorial[0] = factorial[1] = 1;
        for (int i = 2; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        long[] fermatFactorial = new long[n + 1];
        Arrays.fill(fermatFactorial, 1);
        for (int i = 0; i <= n; i++) {
            fermatFactorial[i] = power(factorial[i], MOD - 2) % MOD;
        }

        totalPermutationsPossible = (factorial[(n + 1) / 2] * factorial[n / 2]) % MOD;

        long[][][] t = new long[10][(n + 1) / 2 + 1][totalDigitSum + 1];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= (n + 1) / 2; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }

        long result = solve(0, 0, 0, freq, fermatFactorial, t);
        return (int) (result % MOD);
    }
}