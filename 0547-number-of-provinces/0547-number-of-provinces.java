class Solution {
    public int findCircleNum(int[][] arr) {
        //converting into adj Array
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }
        //
        // System.out.println(adj);
        boolean vis[]=new boolean[adj.size()];
        int count=0;
        for(int i=0;i<adj.size();i++){
            if(!vis[i]){
                dfs(i,vis,adj);
                count++;
            }
            
        }
        return count;
    }
    public static void dfs(int i,boolean vis[],ArrayList<ArrayList<Integer>> adj){
        vis[i]=true;
        for(int j=0;j<adj.get(i).size();j++){
            if(!vis[adj.get(i).get(j)]){
                dfs(adj.get(i).get(j),vis,adj);
            }
        }
    }
}