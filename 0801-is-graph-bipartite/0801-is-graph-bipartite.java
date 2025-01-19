class Solution {
    public boolean isBipartite(int[][] adj) {
        // Code here
        int vis[]=new int[adj.length];
        for(int i=0;i<vis.length;i++) vis[i]=-1;
        for(int i=0;i<vis.length;i++){
            if(vis[i]==-1){
                if(dfs(i,vis,adj,0)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean dfs(int z,int vis[],int [][] adj,int color){
        vis[z]=color;
        for(int i=0;i<adj[z].length;i++){
            if(vis[adj[z][i]]==-1){
                if(dfs(adj[z][i],vis,adj,1-color)==false){
                    return false;
                }
            }else{
                if(vis[adj[z][i]]==color){
                    return false;
                }
            }
        }
        return true;
    }
}