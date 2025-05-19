class Solution {
    public int func(int arr[][],int i,int j1,int j2, int n,int m,int dp[][][]){
        if(j1<0 || j1>=m || j2<0 || j2>=m) return -(int)1e8;
        if(i==n-1){
            if(j1==j2){
                return arr[i][j1];
            }else{
                return arr[i][j1]+arr[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];

        int maxi=-(int)1e8;
        for(int d1=-1;d1<=1;d1++){
            for(int d2=-1;d2<=1;d2++){
                int currVal=func(arr,i+1,j1+d1,j2+d2,n,m,dp);
                if(j1==j2){
                    currVal+=arr[i][j1];
                }else{
                    currVal+=arr[i][j1]+arr[i][j2];
                }
                maxi=Math.max(maxi,currVal);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    public int cherryPickup(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[][][]=new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(arr,0,0,m-1,n,m,dp);
    }
}