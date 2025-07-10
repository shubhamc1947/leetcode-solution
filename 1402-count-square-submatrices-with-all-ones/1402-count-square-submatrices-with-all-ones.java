class Solution {
    public int countSquares(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int prev[]=new int[m];
        // for(int i=0;i<n;i++){
        //     dp[i][0]=arr[i][0];
        // }
        int sum=0;
        for(int j=0;j<m;j++){
            prev[j]=arr[0][j];
            sum+=arr[0][j];
        }
        for(int i=1;i<n;i++){
            int curr[]=new int[m];
            curr[0]=arr[i][0];
            sum+=curr[0];
            for(int j=1;j<m;j++){
                if(arr[i][j]==1){
                    curr[j]=Math.min(prev[j],Math.min(prev[j-1],curr[j-1]))+1;

                }else{
                    curr[j]=0;
                }
                sum+=curr[j];
            }
            prev=curr;
        }
        
        return sum;
    }
}