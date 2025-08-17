class Solution {
    public void dfs(int i,int j,int vis[][],char arr[][],int n,int m,int xCor[],int yCor[] ){
        vis[i][j]=1;
        for(int x=0;x<4;x++){
            int newX=i+xCor[x];
            int newY=j+yCor[x];
            if(newX>=0 && newX<n && newY>=0 && newY<m && vis[newX][newY]==0 && arr[newX][newY]=='1'){
                dfs(newX,newY,vis,arr,n,m,xCor,yCor);
            }
        }
    }
    public int numIslands(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int vis[][]=new int[n][m];//
        int count=0;
        int xCor[]={-1,0,0,1};
        int yCor[]={0,-1,1,0};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='1' && vis[i][j]==0){
                    dfs(i,j,vis,arr,n,m,xCor,yCor);
                    count++;
                }
            }
        }
        return count;
    }
}