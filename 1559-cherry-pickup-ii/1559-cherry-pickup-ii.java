class Solution {
    public int func(int i,int j1,int j2,int n,int m, int arr[][],int dp[][][]){
        if(j1<0 ||j1>=m ||j2<0||j2>=m){
            return 0;
        }
        if(i==n-1){
            if(j1==j2){
                return arr[i][j1];
            }else{
                return arr[i][j1]+arr[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int maxi=Integer.MIN_VALUE;
        for(int x=-1;x<=1;x++){
            for(int y=-1;y<=1;y++){ 
                if(j1==j2){
                    maxi=Math.max(maxi,arr[i][j1]+func(i+1,j1+x,j2+y,n,m,arr,dp));
                }else{
                    maxi=Math.max(maxi,arr[i][j1]+arr[i][j2]+func(i+1,j1+x,j2+y,n,m,arr,dp));
                }
            }
        }
        return dp[i][j1][j2]= maxi;
    }
    public int cherryPickup(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        // i,j1,j2
        int dp[][][]=new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(0,0,m-1,n,m,arr,dp);
    }
}