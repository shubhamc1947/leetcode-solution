class Solution {
    class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public long bfs(int grid[][],int vis[][],int i,int j,int n,int m,int xCor[],int yCor[]){
        Queue<Node> que=new LinkedList<>();
        que.add(new Node(i,j));
        long val=0;
        vis[i][j] = 1;   

        while(!que.isEmpty()){
            Node curr=que.remove();
            int currX=curr.x;
            int currY=curr.y;
            val += grid[currX][currY];

            System.out.println(grid[currX][currY]+"  grid and val "+ val);
            for(int x=0;x<4;x++){
                int newX=currX+xCor[x];
                int newY=currY+yCor[x];
                if(newX>=0 && newX<n && newY>=0 && newY<m){
                    if(grid[newX][newY]!=0 && vis[newX][newY]==0){
                        que.add(new Node(newX,newY));
                        vis[newX][newY] = 1;  

                    }
                }
            }
        }
        return val;
    }
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];

        int xCor[]=new int[]{-1,0,0,1};
        int yCor[]=new int[]{0,-1,1,0};
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0 && vis[i][j]==0){
                    //call bfs or dfs
                    long val=bfs(grid,vis,i,j,n,m,xCor,yCor);
                    System.out.println(val+" val");
                    if(val%k==0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}