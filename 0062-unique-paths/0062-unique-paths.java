class Solution {
    public int helper(int i,int j,int dp[][]){
        if(i==0 && j==0){
            return 1;
        }else if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int left=helper(i,j-1,dp);
        int top=helper(i-1,j,dp);
        return dp[i][j]= left+top;
    }
    public int uniquePaths(int n, int m) {
        int dp[][]=new int[n][m];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }

        // return helper(n-1,m-1,dp);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) {
                    dp[0][0]=1;
                }else{
                    int left=0;
                    int top=0;
                    if(i>0){
                        top=dp[i-1][j];
                    }
                    if(j>0){
                        left=dp[i][j-1];
                    }
                    dp[i][j]=left+top;
                }                
            }
        }
        
        return dp[n-1][m-1];
    }
}