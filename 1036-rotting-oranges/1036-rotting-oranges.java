class Solution {
    public class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int orangesRotting(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        Queue<Pair> que=new LinkedList<>();
        int vis[][]=new int[n][m];
        int freshFruit=0;
        //cloning total grid
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                vis[i][j]=arr[i][j];
                if(arr[i][j]==1){
                    freshFruit++;
                }
                if(arr[i][j]==2){
                    que.add(new Pair(i,j));
                }
            }
        }
        //if none fresh orange , then no time
        if(freshFruit==0){
            return 0;
        }
        //if none rotton orange then not possible
        if(que.isEmpty()){
            return -1;
        }

        int xRep[]={-1,0,0,1};
        int yRep[]={0,-1,1,0};
        
        int freq=-1;
        while(!que.isEmpty()){
            int currSize=que.size();
            // System.out.println(currSize+"current size");

            for(int i=0;i<currSize;i++){
                Pair currNode=que.remove();
                int x=currNode.x;
                int y=currNode.y;

                for(int j=0;j<4;j++){
                    int nextX=x+xRep[j];
                    int nextY=y+yRep[j];

                    if(nextX>=0 && nextY>=0 && nextX<n && nextY<m && vis[nextX][nextY]==1 ){
                        vis[nextX][nextY]=2;
                        freshFruit--;
                        que.add(new Pair(nextX,nextY));
                    }
                }
            }
            freq++;

        }

        return freshFruit==0?freq:-1;


    }
}



