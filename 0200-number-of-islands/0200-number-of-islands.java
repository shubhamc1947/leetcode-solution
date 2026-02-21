class Solution {
    public void dfs(char [][]grid,int vis[][],int i,int j,int xCor[],int yCor[],int n,int m){
        vis[i][j]=1;
        for(int x=0;x<4;x++){
            int newX=i+xCor[x];
            int newY=j+yCor[x];
            if(newX>=0 && newX< n && newY>=0 && newY<m ){
                if(grid[newX][newY]=='1' && vis[newX][newY]==0){
                    dfs(grid,vis,newX,newY,xCor,yCor,n,m);
                }
            }
        }
        
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int vis[][]=new int[n][m];
        int count=0;
        int xCor[]=new int[]{-1,0,0,1};
        int yCor[]=new int[]{0,-1,1,0};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    dfs(grid,vis,i,j,xCor,yCor,n,m);
                    count++;
                }
            }
        }
        return count;
    }
}