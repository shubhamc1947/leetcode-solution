class Solution {
    public int longestCommonSubsequence(String str, String btr) {
        int n=str.length();
        int m=btr.length();
        int dp[]=new int[m];
       
        for(int i=0;i<n;i++){
            int temp[]=new int [m];
            for(int j=0;j<m;j++){
                temp[j]=0;
                if(str.charAt(i)==btr.charAt(j)){
                    temp[j]= 1+ ((i-1>=0 && j-1>=0)? dp[j-1]:0);
                }else{
                    int moveFirst= (i-1>=0)? dp[j]:0;
                    int moveSecond= (j-1>=0)? temp[j-1]:0;
                    temp[j]= Math.max(moveFirst,moveSecond);
                }
            }
            dp=temp;
        }
        return dp[m-1];
    }
}