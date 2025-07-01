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
                    int top=(int)1e8;
                    if(i-1>=0){
                        top=arr[i][j]+prev[j];
                    }
                    int left=(int)1e8;
                    if(j-1>=0){
                        left=arr[i][j]+curr[j-1];
                    }
                    curr[j]=Math.min(left,top);
                }
            }
            prev=curr;

        }
        return prev[m-1];
    }
}