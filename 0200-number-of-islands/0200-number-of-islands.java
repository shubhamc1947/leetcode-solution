class Solution {
    public void dfs(int i,int j,int n,int m, char arr[][],int vis[][],int xcor[],int ycor[]){
        vis[i][j]=1;
        for(int x=0;x<4;x++){
            int ni=i+xcor[x];
            int nj=j+ycor[x];

            if(ni>=0 && nj>=0 && ni<n && nj<m && vis[ni][nj]==0 && arr[ni][nj]=='1'){
                dfs(ni,nj,n,m,arr,vis,xcor,ycor);
            }
        }
    }
    public int numIslands(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int vis[][]=new int[n][m];
        int xcor[]=new int[]{-1,0,0,1};
        int ycor[]=new int[]{0,-1,1,0};
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && arr[i][j]=='1'){
                    dfs(i,j,n,m,arr,vis,xcor,ycor);
                    count++;
                }
            }
        }
        return count;
    }
}