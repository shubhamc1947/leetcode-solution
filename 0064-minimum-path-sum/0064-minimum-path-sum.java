class Solution {
    public int minPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int prev[]=new int[m];

        for(int i=0;i<n;i++){
            int temp[]=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    temp[j]=arr[i][j];
                }else{
                    int left=Integer.MAX_VALUE;
                    int top=Integer.MAX_VALUE;
                    if(i>0) top=prev[j];
                    if(j>0) left=temp[j-1];

                    temp[j]=arr[i][j]+Math.min(left,top);
                }
            }
            prev=temp;
        }
        return prev[m-1];
    }
}