class Solution {
    class Pair{
        int x;
        int y;
        int dis;
        public Pair(int x,int y,int dis){
            this.x=x;
            this.y=y;
            this.dis=dis;
        }
    }
    public int[][] updateMatrix(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int ans[][]=new int[n][m];
        Queue<Pair> que=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    ans[i][j]=-1;
                }else{
                    que.add(new Pair(i,j,0));
                }
            }
        }

        if(que.size()==n*m){
            return arr;
        }
        int xCor[]={-1,0,0,1};
        int yCor[]={0,-1,1,0};
        while(!que.isEmpty()){
            Pair curr=que.remove();
            for(int z=0;z<4;z++){
                int nextX=curr.x+xCor[z];
                int nextY=curr.y+yCor[z];
                if(nextX>=0 && nextY>=0 && nextX<n && nextY<m && ans[nextX][nextY]==-1){
                    ans[nextX][nextY]=curr.dis+1;
                    que.add(new Pair(nextX,nextY,curr.dis+1));
                }
            }
        }
        return ans;
    }
}