class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x,int y){
           this.x=x;
           this.y=y;
        }
    }
    public int dfs(int i,int j,int n,int m,int xCor[],int yCor[],int vis[][],int grid[][]){
        vis[i][j]=1;
        Queue<Pair> que=new LinkedList<>();
        que.add(new Pair(i,j));
        int area=1;
        while(!que.isEmpty()){
            Pair curr=que.remove();
            int currX=curr.x;
            int currY=curr.y;
            for(int d=0;d<4;d++){
                int nextX=xCor[d]+currX;
                int nextY=yCor[d]+currY;
                if(nextX>=0 && nextY>=0 && nextX<n && nextY<m){
                    if(vis[nextX][nextY]==0 && grid[nextX][nextY]==1){
                        que.add(new Pair(nextX,nextY));
                        vis[nextX][nextY]=1;
                        area++;
                    }
                }
            }
        }
        // System.out.println(area);
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int xCor[]=new int[]{-1,0,0,1};
        int yCor[]=new int[]{0,-1,1,0};
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    ans=Math.max(dfs(i,j,n,m,xCor,yCor,vis,grid),ans); 
                }
            }
        }
        return ans;
    }
}
