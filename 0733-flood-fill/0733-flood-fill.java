class Solution {
    public int[][] floodFill(int[][] arr, int sr, int sc, int color) {
        int n=arr.length;
        int m=arr[0].length;
        int vis[][]=new int[n][m];
        if(arr[sr][sc]==color){
            return arr;
        }
        int currColor=arr[sr][sc];
        dfs(sr,sc,color,arr,currColor,vis);
        return arr;
    }
    public static void dfs(int i,int j,int color,int arr[][],int currColor,int vis[][]){
        vis[i][j]=1;
        arr[i][j]=color;
        int xCor[]={-1,0,0,1};
        int yCor[]={0,-1,1,0};
        for(int k=0;k<4;k++){
            int currX=xCor[k]+i;
            int currY=yCor[k]+j;
            if(currX>=0 && currY>=0 && currX<arr.length && currY<arr[0].length && vis[currX][currY]==0 && arr[currX][currY]==currColor){
                dfs(currX,currY,color,arr,currColor,vis);
            }
        }
        
    }
}