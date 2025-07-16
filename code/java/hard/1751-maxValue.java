class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];
        
        for (int i = 1; i <= n; i++) {
            int start = events[i - 1][0];
            int value = events[i - 1][2];
            
            int low = 0, high = i - 2;
            int best = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (events[mid][1] < start) {
                    best = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            int prev = best + 1;
            
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[prev][j - 1] + value);
            }
        }
        
        return dp[n][k];
    }
}