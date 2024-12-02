class Solution {
    public int findCircleNum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int vis[][]=new int [n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if( arr[i][j]==1 && vis[i][j]==0){
                    dfs(arr,vis,i,j,n,m);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(int arr[][],int vis[][],int x,int y,int n,int m){
        vis[x][y]=1;
        vis[y][x]=1;
        for(int i=0;i<m;i++){
            if(vis[y][i]==0 &&arr[y][i]==1){
                dfs(arr,vis,y,i,n,m);
            }
        }
    }
}