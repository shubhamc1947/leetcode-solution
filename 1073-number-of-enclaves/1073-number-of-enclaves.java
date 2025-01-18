class Solution {
    public int numEnclaves(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int vis[][]=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0||i==n-1||j==m-1) && arr[i][j]==1){
                    // count[0]++;
                    dfs(i,j,arr,vis);
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=-1&&arr[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(int i,int j,int arr[][],int vis[][]){
        vis[i][j]=-1;
        // count[0]--;
        int xCor[]={-1,0,0,1};
        int yCor[]={0,-1,1,0};
        for(int z=0;z<4;z++){
            int nextX=xCor[z]+i;
            int nextY=yCor[z]+j;
            if(nextX>=0 && nextY>=0 && nextX<arr.length && nextY<arr[0].length && arr[nextX][nextY]==1 && vis[nextX][nextY]!=-1){
                dfs(nextX,nextY,arr,vis);
            }
        }
    }
}