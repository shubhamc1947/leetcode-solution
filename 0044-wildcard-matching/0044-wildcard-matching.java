class Solution {
    public boolean func(String s1,String s2, int i,int j,int dp[][]){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0) {
            for(int x=0;x<=i;x++){
                if(s1.charAt(x)!='*') return false;
            }
            return true;
        }
        if(dp[i][j]!=-1) return dp[i][j]==1;

        // match
        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?'){
            dp[i][j] = func(s1,s2,i-1,j-1,dp)?1:0;
            return dp[i][j]==1;
        }else{
            if(s1.charAt(i)=='*'){
                //take * as ""
                boolean notTake=func(s1,s2,i-1,j,dp);
                // take * as curr char (but * can be another as well so taking j-1 only)
                boolean take=func(s1,s2,i,j-1,dp);
                dp[i][j] = take || notTake?1:0;
                return take||notTake;
            }else{
                dp[i][j] = 0;
                return false;
            }
        }
        
    }
    public boolean isMatch(String s2, String s1) {
        //assuming s1 will contains * and ? 
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(s1,s2,n-1,m-1,dp);
    }
}