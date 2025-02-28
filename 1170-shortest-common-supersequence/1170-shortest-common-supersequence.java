class Solution {
    
    public String shortestCommonSupersequence(String str1, String str2) {

        char[] s = str1.toCharArray(), t=str2.toCharArray();
        int n=str1.length(), m=str2.length();

        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++) dp[i][0]=0;
        for(int j=0; j<=m; j++) dp[0][j]=0;

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                if(s[i-1]==t[j-1])
                dp[i][j]=1+dp[i-1][j-1];
                
                else 
                dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int i=n,  j=m;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0)
        {
            if(s[i-1]==t[j-1]){
                sb.append(s[i-1]);
                i--; j--;
            }
            else if(dp[i-1][j] <= dp[i][j-1]){
                sb.append(t[j-1]);
                j--;
            }
            // up cell is greater we will move up and will add char s[i-1] to ans.
            else{
                sb.append(s[i-1]);
                i--;
            }
        }

        //adding remaining character of both string.
        while(i-->0) sb.append(s[i]);
        while(j-->0) sb.append(t[j]);
        
        return sb.reverse().toString();
    }
}