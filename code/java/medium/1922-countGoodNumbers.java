class Solution {
    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenWays = modPow(5, evenCount, MOD);
        long oddWays = modPow(4, oddCount, MOD);

        return (int)((evenWays * oddWays) % MOD);
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }
}

//took help from multiple people in the solutions section