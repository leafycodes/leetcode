class Solution {
    public int maxDifference(String str, int minLength) {
        int strLength = str.length();
        int maxDiff = Integer.MIN_VALUE;

        for (int charA = 0; charA <= 4; ++charA) {
            for (int charB = 0; charB <= 4; ++charB) {
                if (charA == charB) continue;

                int[] prefixCountA = new int[strLength + 1];
                int[] prefixCountB = new int[strLength + 1];
                
                for (int i = 1; i <= strLength; ++i) {
                    prefixCountA[i] = prefixCountA[i - 1] + (str.charAt(i - 1) - '0' == charA ? 1 : 0);
                    prefixCountB[i] = prefixCountB[i - 1] + (str.charAt(i - 1) - '0' == charB ? 1 : 0);
                }

                int[][] parityCache = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    Arrays.fill(parityCache[i], Integer.MIN_VALUE);
                }

                int windowStart = 0;

                for (int windowEnd = minLength; windowEnd <= strLength; windowEnd++) {
                    while (windowEnd - windowStart >= minLength && 
                           prefixCountA[windowEnd] > prefixCountA[windowStart] && 
                           prefixCountB[windowEnd] > prefixCountB[windowStart]) {
                        int parityA = prefixCountA[windowStart] % 2;
                        int parityB = prefixCountB[windowStart] % 2;
                        parityCache[parityA][parityB] = Math.max(parityCache[parityA][parityB], 
                                                              prefixCountB[windowStart] - prefixCountA[windowStart]);
                        windowStart++;
                    }

                    int currentParityA = prefixCountA[windowEnd] % 2;
                    int currentParityB = prefixCountB[windowEnd] % 2;
                    int bestMatch = parityCache[1 - currentParityA][currentParityB];
                    
                    if (bestMatch != Integer.MIN_VALUE) {
                        maxDiff = Math.max(maxDiff, (prefixCountA[windowEnd] - prefixCountB[windowEnd]) + bestMatch);
                    }
                }
            }
        }

        return maxDiff == Integer.MIN_VALUE ? -1 : maxDiff;
    }
}

// took a lot of help