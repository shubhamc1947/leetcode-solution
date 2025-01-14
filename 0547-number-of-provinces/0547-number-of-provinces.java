class Solution {
    public int findCircleNum(int[][] arr) {
        int n=arr.length;
        boolean vis[]=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,arr);
                count++;
            }
        }
        return count;
    }
    public static void dfs(int node,boolean vis[],int arr[][]){
        vis[node]=true;
        for(int j=0;j<vis.length;j++){
            if(arr[node][j]==1 && vis[j]==false){
                dfs(j,vis,arr);
            }
        }
    }
}   