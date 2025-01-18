class Solution {
    public void solve(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        char[][] ans=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 || j==m-1 ) && arr[i][j]=='O'){
                    dfs(i,j,ans,arr);
                }
            }
        }
        //filter
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ans[i][j]!='Z'){
                    arr[i][j]='X';
                }
            }
        }
       
    }
    public static void dfs(int i,int j,char[][]ans,char[][]arr){
        ans[i][j]='Z';
        int xCor[]={-1,0,0,1};
        int yCor[]={0,-1,1,0};
        for(int z=0;z<4;z++){
            int nextX=xCor[z]+i;
            int nextY=yCor[z]+j;
            if(nextX>=0 && nextY>=0 && nextX<arr.length && nextY<arr[0].length && ans[nextX][nextY]!='Z' && arr[nextX][nextY]=='O'){
                dfs(nextX,nextY,ans,arr);
            }
        }
    }
}