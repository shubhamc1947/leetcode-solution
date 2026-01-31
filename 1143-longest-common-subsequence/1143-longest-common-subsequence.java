class Solution {
    public int helper(String str,String btr,int i,int j,int dp[][]){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(str.charAt(i)==btr.charAt(j)){
            return dp[i][j]= 1+helper(str,btr,i-1,j-1,dp);
        }else{
            int moveFirst=helper(str,btr,i-1,j,dp);
            int moveSecond=helper(str,btr,i,j-1,dp);
            return dp[i][j]= Math.max(moveFirst,moveSecond);
        }

    }
    public int longestCommonSubsequence(String str, String btr) {
        int n=str.length();
        int m=btr.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(str,btr,n-1,m-1,dp);
    }
}