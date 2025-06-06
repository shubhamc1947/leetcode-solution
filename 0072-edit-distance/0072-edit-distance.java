class Solution {
    public int func(int i,int j,String s1, String s2, int dp[][]){
        if(i<0) return j+1;
        if(j<0) return i+1;
        //match
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            //match
            return dp[i][j]= func(i-1,j-1,s1,s2,dp);
        }else{
            // insert
            int insert=1+func(i,j-1,s1,s2,dp);
            //delete
            int delete=1+func(i-1,j,s1,s2,dp);
            //replace
            int replace=1+func(i-1,j-1,s1,s2,dp);
            return dp[i][j]= Math.min(insert,Math.min(delete,replace));
        }
    }
    public int minDistance(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(n-1,m-1,s1,s2,dp);
    }
}