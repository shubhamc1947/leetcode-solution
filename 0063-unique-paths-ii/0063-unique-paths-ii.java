class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[]=new int[m];
        
        dp[0]=1;
        for(int i=0;i<n;i++){
            int temp[]=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0 && arr[i][j]==0) {
                    temp[j]=1;
                }else{
                    if(arr[i][j]==1){
                        temp[j]=0;
                    }else{
                        int left=0,top=0;   
                        if(j>0) left=temp[j-1];
                        if(i>0) top=dp[j];
                        temp[j]=top+left;
                    }
                }
            }
            dp=temp;
        }
        return dp[m-1];
    }
}