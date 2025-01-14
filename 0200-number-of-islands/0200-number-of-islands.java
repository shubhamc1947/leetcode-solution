class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length,m=grid[0].length;
        int vis[][]=new int[n][m];
        int noOfIslands=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' &&vis[i][j]==0 ){
                    dfs(i,j,grid,vis);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }
    public static void dfs(int i,int j,char grid[][],int vis[][]){
        vis[i][j]=1;
        
        int xAxis[]={-1,0,0,1};
        int yAxis[]={0,1,-1,0};
        for(int k=0;k<4;k++){
            int currX=(int)xAxis[k]+i;
            int currY=(int)yAxis[k]+j;
            if(currX>=0 && currY>=0 && currX<grid.length && currY<grid[0].length && grid[currX][currY]=='1' && vis[currX][currY]==0){
                dfs(currX,currY,grid,vis);
            }
        }
    }
}