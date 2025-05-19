class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        
        int maxi=Integer.MAX_VALUE;

        int prev[]=new int[m];

        //base case initilization
        for(int j=0;j<m;j++){
            prev[j]=arr[0][j];
        }

        for(int i=1;i<n;i++){
            int curr[]=new int[m];
            for(int j=0;j<m;j++){
                int left=(int)1e8;
                int right=(int)1e8;

                int top=prev[j]+arr[i][j];
                if(j-1>=0) left=prev[j-1]+arr[i][j];
                if(j+1<m) right=prev[j+1]+arr[i][j];

                curr[j]=Math.min(left,Math.min(right,top));
            }
            prev=curr;
        }

        int mini=prev[0];
        for(int j=1;j<m;j++){
            mini=Math.min(mini,prev[j]);
        }
        return mini;
        
    }
}