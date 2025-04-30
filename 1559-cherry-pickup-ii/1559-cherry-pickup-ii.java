class Solution {
    public int f(int arr[][],int i,int j1,int j2,int n,int m,int dp[][][]){
        if(j1<0 || j1>=m || j2<0 || j2>=m ){
            return -(int)1e8;
        }
        if(i==n-1){
            if(j1==j2) return arr[i][j1];
            else{
                return arr[i][j1]+arr[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }
        int maxi=Integer.MIN_VALUE;
        for(int x=-1;x<=1;x++){
            for(int y=-1;y<=1;y++){
                int robo=f(arr,i+1,j1+x,j2+y,n,m,dp);
                if(j1==j2){
                    robo+=arr[i][j1];
                }else{
                    robo+=arr[i][j1]+arr[i][j2];
                }

                maxi=Math.max(maxi,robo);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    public int cherryPickup(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[][][]=new int [n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return f(arr,0,0,m-1,n,m,dp);
    }
}