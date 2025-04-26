class Solution {
    static final int MOD = (int)1e9 + 7;
    long[] fact, invFact;

    long power(long x, long y) {
        long res = 1;
        x %= MOD;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % MOD;
            y >>= 1;
            x = (x * x) % MOD;
        }
        return res;
    }

    void precompute(int n) {
        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = (fact[i - 1] * i) % MOD;
        invFact[n] = power(fact[n], MOD - 2);
        for (int i = n - 1; i >= 0; i--)
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
    }

    long comb(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    public int idealArrays(int n, int maxValue) {
        int maxLen = 14;
        precompute(n + maxLen);

        long[][] count = new long[maxLen + 1][maxValue + 1];
        for (int i = 1; i <= maxValue; i++) {
            count[1][i] = 1;
        }

        for (int k = 2; k <= maxLen; k++) {
            for (int i = 1; i <= maxValue; i++) {
                for (int j = i * 2; j <= maxValue; j += i) {
                    count[k][j] = (count[k][j] + count[k - 1][i]) % MOD;
                }
            }
        }

        long ans = 0;
        for (int k = 1; k <= maxLen; k++) {
            long ways = 0;
            for (int i = 1; i <= maxValue; i++) {
                ways = (ways + count[k][i]) % MOD;
            }
            ans = (ans + (ways * comb(n - 1, k - 1)) % MOD) % MOD;
        }

        return (int) ans;
    }
}
