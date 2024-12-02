class Solution {
    public boolean validPath(int n, int[][] edges, int source, int dest) {
        if (source == dest) {
            return true;
        }
        int vis[]=new int[n];
        //creating a adj list
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        System.out.println(adj);
        return dfs(source,vis,adj,dest);
        
    }
    public static boolean dfs(int currIdx,int []vis,List<List<Integer>>adj,int dest){
        if(dest==currIdx){
            return true;
        }
        vis[currIdx]=1;
        for(int i=0;i<adj.get(currIdx).size();i++){
            if(vis[adj.get(currIdx).get(i)]==0){
                if( dfs(adj.get(currIdx).get(i),vis,adj,dest)){
                    return true;
                };
            }
        }
        return false;
    }
}