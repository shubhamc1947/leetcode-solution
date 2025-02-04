class Solution {
    public class Triple{
        int x;
        int y;
        int z;
        Triple(int x,int y,int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }

    public class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int findCheapestPrice(int n, int[][] f, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Pair> temp=new ArrayList<>();
            adj.add(temp);
        }
        for(int i=0;i<f.length;i++){
            adj.get(f[i][0]).add(new Pair(f[i][1],f[i][2]));
        }

        int dis[]=new int[n];
        for(int i=0;i<n;i++){
            dis[i]=(int)1e9;
        }
        dis[src]=0;
        Queue<Triple> que=new LinkedList<>();
        que.add(new Triple(0,src,0));

        // steps , node , dis
        while(!que.isEmpty()){
            Triple curr=que.remove();
            int currStep=curr.x;
            int currNode=curr.y;
            int currDis=curr.z;

            if(currStep>k) break;
            for(int i=0;i<adj.get(currNode).size();i++){
                int nextNode=adj.get(currNode).get(i).x;
                int nextDis=adj.get(currNode).get(i).y;
                if(currDis+nextDis<dis[nextNode]){
                    dis[nextNode]=currDis+nextDis;
                    que.add(new Triple(currStep+1,nextNode,currDis+nextDis));
                }
            }
        }


        if(dis[dst]==(int)1e9) return -1;
        return dis[dst];

    }
}