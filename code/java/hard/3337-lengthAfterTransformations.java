class Solution {
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[] freq = new long[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        long[][] matrix = new long[26][26];
        for (int j = 0; j < 26; j++) {
            int numSteps = nums.get(j);
            for (int k = 1; k <= numSteps; k++) {
                int i = (j + k) % 26;
                matrix[i][j]++;
            }
        }

        long[][] resultMatrix = matrixPower(matrix, t);

        long[] finalFreq = new long[26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                finalFreq[i] = (finalFreq[i] + resultMatrix[i][j] * freq[j]) % MOD;
            }
        }

        long total = 0;
        for (long count : finalFreq) {
            total = (total + count) % MOD;
        }
        return (int) total;
    }

    private long[][] matrixPower(long[][] matrix, int power) {
        int n = matrix.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        while (power > 0) {
            if (power % 2 == 1) {
                result = matrixMultiply(result, matrix);
            }
            matrix = matrixMultiply(matrix, matrix);
            power /= 2;
        }
        return result;
    }

    private long[][] matrixMultiply(long[][] a, long[][] b) {
        int n = a.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long sum = 0;
                for (int k = 0; k < n; k++) {
                    sum = (sum + a[i][k] * b[k][j]) % MOD;
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}