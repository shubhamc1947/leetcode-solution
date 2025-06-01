class Solution {
    public String func(String s1, String s2) {
        // code here
        int n1=s1.length();
        int n2=s2.length();
        int dp[][]=new int[n1+1][n2+1];
        //creating the dp of LCS 
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        //Creating the shortestCommonSupersequence
        StringBuilder ans=new StringBuilder();
        int i=n1,j=n2;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans.append(s1.charAt(i-1));
                i--;
                j--;
            }else if( dp[i-1][j]>dp[i][j-1]){
                ans.append(s1.charAt(i-1));
                i--;
            }else{
                ans.append(s2.charAt(j-1));
                j--;
            }
        }

        //covering the left String 
        while(i>0){
            ans.append(s1.charAt(i-1));
            i--;
        }
        while(j>0){
            ans.append(s2.charAt(j-1));
            j--;
        }
        //reverse String is the Answer
        return ans.reverse().toString();
        
    }
    public String shortestCommonSupersequence(String s1, String s2) {
        
        return func(s1,s2);
    }
}