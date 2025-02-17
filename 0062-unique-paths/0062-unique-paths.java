class Solution {
    public int uniquePaths(int m, int n) {
        int[][] path=new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                path[i][j]=-1;
            }
        }
        return find(path, m-1, n-1);
    }
    private int find(int[][] path, int m, int n){
        //base cases
        if(m==0 || n==0) return 1;
        if(path[m][n] != -1) return path[m][n];

        //recursive case
        path[m][n]=find(path, m-1,n) + find(path, m, n-1);

        return path[m][n];
    }
}