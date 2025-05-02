class Solution {
    static final int MOD=1_000_000_007;
    int[][] dp;
    public int waysToReachTarget(int target, int[][] types) {
        dp=new int[types.length][target+1];
        for(int i=0;i<types.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,target,types);
    }

    private int helper(int index, int remaining, int[][] types){
        if(remaining==0) return 1;
        if(index==types.length || remaining<0) return 0;

        if(dp[index][remaining]!=-1){
            return dp[index][remaining];
        }

        int ways=0;
        int count=types[index][0];
        int marks=types[index][1];

        for(int k=0;k<=count;k++){
            int totalMarks=k*marks;
            if(totalMarks>remaining) break;
            ways=(ways+helper(index+1,remaining-totalMarks,types))%MOD;
        }
        return dp[index][remaining]=ways;
    }
}