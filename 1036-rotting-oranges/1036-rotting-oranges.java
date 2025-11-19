class Solution {
    class Node{
        int x;
        int y;
        public Node (int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        //clone the array and count current status and Push rotton orange for t=Zero inside queue
        Queue<Node> que=new LinkedList<>();
        int cloneGrid[][]=new int[n][m];
        int totalSafeOrange=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    cloneGrid[i][j]=2;
                    que.add(new Node(i,j));
                }else if(grid[i][j]==1){
                    totalSafeOrange++;
                    cloneGrid[i][j]=1;
                }
            }
        }
        if(totalSafeOrange==0) return 0;
        if(que.isEmpty()) return -1;
        int xCor[]={-1,0,0,1};
        int yCor[]={0,-1,1,0};

        int time=-1;
        while(!que.isEmpty()){
            int currQueSize=que.size();
            time++;
            for(int z=0;z<currQueSize;z++){
                Node currNode=que.remove();
                for(int a=0;a<4;a++){
                    int nextX=currNode.x+xCor[a];
                    int nextY=currNode.y+yCor[a];
                    if(nextX>=0 && nextY>=0 && nextX<n && nextY<m && cloneGrid[nextX][nextY]==1){
                        cloneGrid[nextX][nextY]=2;
                        que.add(new Node(nextX,nextY));
                        totalSafeOrange--;
                    }
                }
            }
        }
        return totalSafeOrange==0?time:-1;

    }
}