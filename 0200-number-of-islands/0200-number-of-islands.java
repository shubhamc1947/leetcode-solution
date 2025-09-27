class Solution {
    public void dfs(char arr[][],int i,int j,int vis[][],int xCor[],int yCor[],int n,int m){
        vis[i][j]=1;

        for(int a=0;a<4;a++){
            int newX=i+xCor[a];
            int newY=j+yCor[a];
            if(newX>=0 && newY>=0 && newX<n && newY<m){// check if valid coordinate
                if( arr[newX][newY]=='1' && vis[newX][newY]==0){//check if not visited and island
                    dfs(arr,newX,newY,vis,xCor,yCor,n,m);
                }
            }
        }
    }
    public int numIslands(char[][] arr) {
        int n=arr.length; // no of rows
        int m=arr[0].length; // no. of columns

        int vis[][]=new int[n][m];//0 === not visited , 1==visited

        int xCor[]=new int[]{-1,0,0,1};
        int yCor[]=new int[]{0,-1,1,0};

        int ans=0;

        for(int i=0;i<n;i++){
            for (int j=0;j<m; j++){
                if(arr[i][j]=='1' && vis[i][j]==0){
                    dfs(arr,i,j,vis,xCor,yCor,n,m);
                    ans++;
                }
            }
        }

        return ans;

    }
}