class Solution {
    public int minPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int prev[]=new int[m];

        for(int i=0;i<n;i++){
            int curr[]=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    curr[j]=arr[i][j];
                }else{
                    int left=(int)1e7;
                    int top=(int)1e7;
                    if(i>0) top=prev[j]+arr[i][j];
                    if(j>0) left=curr[j-1]+arr[i][j];
                    curr[j]=Math.min(left,top);
                }
            }
            prev=curr;
        }
        return prev[m-1];
    }
}