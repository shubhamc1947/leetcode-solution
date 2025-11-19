class Solution {
    class Node{
        int x;
        int y;
        int idx;
        public Node(int x,int y,int idx){
            this.idx=idx;
            this.x=x;
            this.y=y;
        }
    }
    public int shortestPathBinaryMatrix(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        if(arr[0][0]==1 || arr[n-1][m-1]==1) return -1;
        if(arr[0][0]==0 && n==1 && m==1) return 1;
        int vis[][]=new int[n][m];

        Queue<Node> que=new LinkedList<>();
        que.add(new Node(0,0,1));
        vis[0][0]=1;
        while(!que.isEmpty()){
            Node curr=que.remove();

            for(int p=-1;p<=1;p++){
                for(int q=-1;q<=1;q++){
                    int nextX=curr.x+p;
                    int nextY=curr.y+q;
                    int nextIdx=curr.idx+1;
                    if(nextX>=0 &&nextX<n && nextY>=0 && nextY<m && arr[nextX][nextY]==0 && vis[nextX][nextY]==0){
                        if(nextX==n-1 && nextY==m-1){
                            return nextIdx;
                        }
                        que.add(new Node(nextX,nextY,nextIdx));
                        vis[nextX][nextY]=1;
                        
                    }
                }
            }
        }
        return -1;
    }
}