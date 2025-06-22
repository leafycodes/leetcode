class Solution {
    public long distributeCandies(int n, int limit) {
        long total = comb(n + 2, 2);
        long invalid1 = 3 * comb(n - (limit + 1) + 2, 2);
        long invalid2 = 3 * comb(n - 2 * (limit + 1) + 2, 2);
        long invalid3 = comb(n - 3 * (limit + 1) + 2, 2);
        long result = total - invalid1 + invalid2 - invalid3;
        return Math.max(result, 0);
    }

    private long comb(long a, long b) {
        if (a < b)
            return 0;
        return a * (a - 1) / 2;
    }
}