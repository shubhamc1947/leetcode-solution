class Solution {
    public int islandPerimeter(int[][] arr) {
        int vis[][]=new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==1){
                    return dfs(i,j,arr,vis);
                }
            }
        }
        return 0;
    }
    public static int dfs(int i,int j,int arr[][],int vis[][]){
        if(i<0 ||j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==0){
            return 1;
        }else if(vis[i][j]==1){
            return 0;
        }
        vis[i][j]=1;
        int xAxis[]={-1,0,0,1};
        int yAxis[]={0,1,-1,0};
        int currParimeter=0;
        for(int x=0;x<4;x++){
            currParimeter+=dfs(i+xAxis[x],j+yAxis[x],arr,vis);
        }
        return currParimeter;
    }
}