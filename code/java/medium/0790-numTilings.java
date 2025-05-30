import java.util.Arrays;

class Solution {
    private int MOD=1_000_000_007;
    public int numTilings(int n) {
        int[] memo=new int[1001];
        Arrays.fill(memo,-1);

        return solve(n,memo);
    }
    private int solve(int n, int[] memo){
        if(n==1 || n==2){
            return n;
        }
        if(n==3){
            return 5;
        }
        if(memo[n]!=-1){
            return memo[n];
        }

        return memo[n]=(2*solve(n-1,memo)%MOD + solve(n-3,memo)%MOD)%MOD;
    }
}

//way 2

class Solution {
    private int MOD=1_000_000_007;
    public int numTilings(int n) {
        if(n==1 || n==2){
            return n;
        }
        int[] dp=new int[n+1];

        dp[1]=1;
        dp[2]=2;
        dp[3]=5;

        for(int i=4;i<dp.length;i++){
            dp[i]=(2*dp[i-1]%MOD+dp[i-3]%MOD)%MOD;
        }
        return dp[n];
    }
}