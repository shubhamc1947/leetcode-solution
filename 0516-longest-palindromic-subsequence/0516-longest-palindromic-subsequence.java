class Solution {
    public int longestPalindromeSubseq(String s) {
        String t=new StringBuilder(s).reverse().toString();

        int n1=s.length();
        int n2=t.length();
        int dp[][]=new int[n1+1][n2+1];
        for(int idx1=1;idx1<=n1;idx1++){
            for(int idx2=1;idx2<=n2;idx2++){
                if(s.charAt(idx1-1)==t.charAt(idx2-1)){
                    dp[idx1][idx2]=1+dp[idx1-1][idx2-1];
                }else{
                    dp[idx1][idx2]=Math.max(dp[idx1-1][idx2],dp[idx1][idx2-1]);
                }
            }
        }

        
        return dp[n1][n2];
    }
}