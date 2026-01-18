class Solution {
    int MOD=1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][]=new int[n+1][target+1];
        
        // return helper(n,k,target,dp);
        // n=>0
        // target target=>0
        dp[0][0]=1;
        int prev[]=new int[target+1];
        prev[0]=1;
        for(int i=1;i<=n;i++){
            int temp[]=new int[target+1];
            for(int tar=target;tar>=0;tar--){
                int way=0;
                
                for(int j=1;j<=k;j++){
                    if(tar-j>=0){
                        way=(way+ prev[tar-j])%MOD;
                    }
                }

                temp[tar]= way;

            }
            prev=temp;
        }
        return prev[target];
    }

}