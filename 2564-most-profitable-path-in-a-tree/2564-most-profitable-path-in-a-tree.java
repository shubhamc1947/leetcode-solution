class Solution {
    int [] nodeDegree;
    int maxP = Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        int [] distOfBob =   new int[amount.length];
        Arrays.fill(distOfBob, Integer.MAX_VALUE);
        int n = amount.length;
        
        List<Integer> [] adj = new ArrayList[amount.length];
        for(int i = 0; i < amount.length; i++) adj[i] = new ArrayList<>();
        
        nodeDegree = new int[n];
        Arrays.fill(nodeDegree, 0);
        for(int [] e : edges){
            
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
            nodeDegree[e[0]]++;
            nodeDegree[e[1]]++;
        }
        
        boolean [] visAlice = new boolean[n];
        boolean [] visbob =  new boolean[n];
        Set<Integer> path = new HashSet<>();
        dfsBob(adj, bob,visbob, distOfBob, 0, path);
        for(int i = 0; i < n; i++) {
            if(!path.contains(i)){
                distOfBob[i] = Integer.MAX_VALUE;
            }
        }
        dfsAlice(adj,  0, visAlice, distOfBob , 0 , 0, amount);

        return maxP;
        
    }
    boolean dfsBob(List<Integer> [] adj, int bob, boolean [] visbob, int [] distOfBobc, int d, Set<Integer> path){
        visbob[bob] = true;
        distOfBobc[bob] = d;
        if(bob == 0){
            path.add(bob);
            return true;
        }
        path.add(bob);
        for(int nextNode : adj[bob]){
            if(!visbob[nextNode]){
                visbob[nextNode] = true;
                if(dfsBob(adj,nextNode, visbob, distOfBobc, d + 1, path)) return true;
            }   
        }
        path.remove(bob);
        return false;
    }
    void dfsAlice(List<Integer> [] adj, int alice, boolean [] visAlice,int []  distOfBob , int d, int score, int[] amount){

        visAlice[alice] = true;
        if(d == distOfBob[alice]){
            score+=(amount[alice]/2);
        }
        else if(d < distOfBob[alice]){
            score+=(amount[alice]);
        }
        else if(d == 0){
            score+=(amount[alice]);
        }
        for(int nextNode : adj[alice]){
            if(!visAlice[nextNode]){
                visAlice[nextNode] = true;
                dfsAlice(adj, nextNode, visAlice,distOfBob, d + 1, score, amount);
            }   
        }
        if(nodeDegree[alice] == 1 && alice!= 0){
            maxP = Math.max(score, maxP);
        }
    }
}