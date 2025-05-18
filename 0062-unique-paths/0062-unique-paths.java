class Solution {
    public int uniquePaths(int n, int m) {
        int dp[]=new int[m];
        
        for(int i=0;i<n;i++){
            int temp[]=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0) {
                    temp[j]=1;
                }else{
                    int right=0,bottom=0;
                    if(j>0) right=temp[j-1];
                    if(i>0) bottom=dp[j];
                    temp[j]=right+bottom;
                }
            }
            dp=temp;
        }

        return dp[m-1];
    }
}