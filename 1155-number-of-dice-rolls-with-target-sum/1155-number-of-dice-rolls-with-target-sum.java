class Solution {
    int MOD = 1000000007;

    public int helper(int i,int k,int tar,int dp[][]){
        if(i==0) return tar==0?1:0;
        if(tar<0) return 0;
        if(dp[i][tar]!=-1) return dp[i][tar];
        int way=0;
        for(int j=1;j<=k;j++){
            way=(way+helper(i-1,k,tar-j,dp))%MOD;
        }

        return dp[i][tar]= way;
    }
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][]=new int[n+1][target+1];
        
        // return helper(n,k,target,dp);
        // n=>0
        // target target=>0
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int tar=target;tar>=0;tar--){
                int way=0;
                
                for(int j=1;j<=k;j++){
                    if(tar-j>=0){
                        way=(way+ dp[i-1][tar-j])%MOD;
                    }
                }

                dp[i][tar]= way;

            }
        }
        return dp[n][target];
    }

}