class Solution {
    private static final int MOD = 1_000_000_007;

    public int possibleStringCount(String word, int k) {
        List<Integer> changeableGroupsYLimits = new ArrayList<>();
        long totalCombinations = 1;
        int minPossibleLength = 0;

        int i = 0;
        while (i < word.length()) {
            int j = i;
            while (j < word.length() && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            int currentGroupLength = j - i;
            minPossibleLength++;

            totalCombinations = (totalCombinations * currentGroupLength) % MOD;
            
            if (currentGroupLength > 1) {
                changeableGroupsYLimits.add(currentGroupLength - 1);
            }
            i = j;
        }

        if (k <= minPossibleLength) {
            return (int) totalCombinations;
        }

        int maxDeltaExclusive = k - minPossibleLength; 
        
        int[] dp = new int[maxDeltaExclusive]; 
        dp[0] = 1; 

        for (int y_limit : changeableGroupsYLimits) {
            int[] next_dp = new int[maxDeltaExclusive];
            
            long[] dp_prefix_sum = new long[maxDeltaExclusive + 1]; 
            for(int j = 0; j < maxDeltaExclusive; j++) {
                dp_prefix_sum[j+1] = (dp_prefix_sum[j] + dp[j]) % MOD;
            }

            for (int current_delta_sum = 0; current_delta_sum < maxDeltaExclusive; current_delta_sum++) {
                int lower_idx = current_delta_sum - y_limit;
                int upper_idx = current_delta_sum;

                lower_idx = Math.max(0, lower_idx);

                if (upper_idx < lower_idx) {
                    next_dp[current_delta_sum] = 0;
                    continue;
                }

                long ways_from_prev_dp = (dp_prefix_sum[upper_idx + 1] - dp_prefix_sum[lower_idx] + MOD) % MOD;
                next_dp[current_delta_sum] = (int) ways_from_prev_dp;
            }
            dp = next_dp;
        }

        long invalidCombinationsCount = 0;
        for (int j = 0; j < maxDeltaExclusive; j++) { 
            invalidCombinationsCount = (invalidCombinationsCount + dp[j]) % MOD;
        }

        return (int) ((totalCombinations - invalidCombinationsCount + MOD) % MOD);
    }
}

// long live the internet gods