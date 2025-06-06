class Solution {

    public boolean isMatch(String s2, String s1) {
        //assuming s1 will contains * and ? 
        int n=s1.length();
        int m=s2.length();
        boolean dp[][]=new boolean[n+1][m+1];
        
        dp[0][0]=true;
        for(int j=1;j<=m;j++){
            dp[0][j]=false;
        }
        for(int i=1;i<=n;i++){
            boolean flag=false;
            for(int x=1;x<=i;x++){
                if(s1.charAt(x-1)!='*'){
                     flag=true;
                     break;
                }
            }
            if(!flag){
                dp[i][0]=true;
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    if(s1.charAt(i-1)=='*'){
                        //take * as ""
                        boolean notTake=dp[i-1][j];
                        // take * as curr char (but * can be another as well so taking j-1 only)
                        boolean take=dp[i][j-1];
                        dp[i][j] = take || notTake?true:false;
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[n][m];
    }
}