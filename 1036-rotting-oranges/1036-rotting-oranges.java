class Solution {
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public int orangesRotting(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int vis[][]=new int[n][m];
        Queue<Pair> que=new LinkedList<>();
        int freshCount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==2){
                    que.add(new Pair(i,j));
                    vis[i][j]=1;
                }
                if(arr[i][j]==1){
                    freshCount++;
                }

            }
        }
        if(freshCount==0){
            return 0;
        }
        if(que.isEmpty()){
            return -1;
        }
        int timer=-1;
        
        // System.out.println(freshCount+" fresh count");
        while(!que.isEmpty()){
            timer++;
            // System.out.println(que.size()+"-----------");
            // if(que.size()==1){
            //     System.out.println(que.peek().x+"--------"+que.peek().y+"---------");
            // }
            int size=que.size();
            for(int z=1;z<=size;z++){
                Pair curr=que.remove();
                int currX=curr.x;
                int currY=curr.y;
                int xCor[]={-1,0,0,1};
                int yCor[]={0,1,-1,0};

                for(int p=0;p<4;p++){
                    int nextX=xCor[p]+currX;
                    int nextY=yCor[p]+currY;
                    if(nextX>=0 && nextY>=0 && nextX<n && nextY<m && arr[nextX][nextY]==1 && vis[nextX][nextY]==0){
                        // System.out.println(arr[nextX][nextY]+"--------"+nextX+"-----"+nextY);
                        vis[nextX][nextY]=1;
                        que.add(new Pair(nextX,nextY));
                        freshCount--;
                    }
                }
            }
        }
        
        return freshCount==0?timer:-1;
    }
}