class Solution {
    public int helper(int arr[][],int idx,int j1,int j2,int m,int n, int dp[][][]){
        if(j1<0 ||j2<0 ||j1>=m||j2>=m) return Integer.MIN_VALUE;
        if(idx==n-1) {
            if(j1==j2) return arr[idx][j1];
            return arr[idx][j1]+arr[idx][j2];
        }
        if(dp[idx][j1][j2]!=-1) return dp[idx][j1][j2];
        int maxi=Integer.MIN_VALUE;
        for(int x=-1;x<=1;x++){
            for(int y=-1;y<=1;y++){
                int next=helper(arr,idx+1,j1+x,j2+y,m,n,dp);
                if(j1==j2){
                    maxi=Math.max(maxi,next+arr[idx][j2]);
                }else{
                    maxi=Math.max(maxi,next+arr[idx][j1]+arr[idx][j2]);
                }
            }
        }
        return dp[idx][j1][j2]= maxi;
    }
    public int cherryPickup(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int idx=0;
        int j1=0;
        int j2=m-1;
        int dp[][][]=new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(arr,idx,j1,j2, m, n,dp);
    }
}