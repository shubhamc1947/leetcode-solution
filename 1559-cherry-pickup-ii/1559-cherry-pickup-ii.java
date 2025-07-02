class Solution {
    
    public int cherryPickup(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        // i,j1,j2
        int dp[][][]=new int[n][m][m];
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2){
                    dp[n-1][j1][j2]=arr[n-1][j1];
                }else{
                    dp[n-1][j1][j2]=arr[n-1][j1]+arr[n-1][j2];
                }
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxi=Integer.MIN_VALUE;
                    for(int x=-1;x<=1;x++){
                        for(int y=-1;y<=1;y++){ 
                            int ans=0;
                            if(j1==j2){
                                ans=arr[i][j1];
                            }else{
                                ans=arr[i][j1]+arr[i][j2];
                            }
                            if(j1+x<0||j1+x>=m || j2+y<0||j2+y>=m){
                                ans+=0;
                            }else{
                                ans+=dp[i+1][j1+x][j2+y];
                            }
                            maxi=Math.max(maxi,ans);
                            dp[i][j1][j2] = maxi; 
                        }
                    }
                }
            }
        }

        return dp[0][0][m-1];
    }
}