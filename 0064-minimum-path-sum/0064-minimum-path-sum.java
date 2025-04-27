class Solution {
    public int minPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int prev[]=new int[m];//
        
        for(int i=0;i<n;i++){
            int curr[]=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    curr[j]= arr[i][j];
                }
                else{
                    int right=Integer.MAX_VALUE,down=Integer.MAX_VALUE;
                    if(j-1>=0) right=curr[j-1]+arr[i][j];
                    if(i-1>=0) down=prev[j]+arr[i][j];

                    curr[j]=Math.min(right,down);
                }
            }
            prev=curr;
        }
        return prev[m-1];
    }
}