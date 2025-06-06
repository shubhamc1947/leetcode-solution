class Solution {
    
    public int minDistance(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    //match
                    dp[i][j]= 0 + dp[i-1][j-1];
                }else{
                    // insert
                    int insert=1+dp[i][j-1];
                    //delete
                    int delete=1+dp[i-1][j];
                    //replace
                    int replace=1+dp[i-1][j-1];
                    dp[i][j]= Math.min(insert,Math.min(delete,replace));
                }
            }
        }

        return dp[n][m];
    }
}