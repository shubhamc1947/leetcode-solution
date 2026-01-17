class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        if(arr[0][0]==1) return 0;
        int n=arr.length;
        int m=arr[0].length;
        if(arr[n-1][m-1]==1) return 0;
        
        int prev[]=new int[m];
        Arrays.fill(prev,-1);

        for(int i=0;i<n;i++){
            int temp[]=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    temp[j]=1;
                }else if(arr[i][j]==1){
                    temp[j]=0;
                }else{
                    int left=0;
                    int top=0;
                    if(i>0) top=prev[j];
                    if(j>0) left=temp[j-1];
                    temp[j]=left+top;
                }
            }
            prev=temp;
        }

        return prev[m-1];
    }
}