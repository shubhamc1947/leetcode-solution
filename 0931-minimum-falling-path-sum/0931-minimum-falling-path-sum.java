class Solution {
   
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int prev[]=new int[m];
        Arrays.fill(prev,-1);
        
        for(int j=0;j<m;j++){
            prev[j]=arr[0][j];
        }


        for(int i=1;i<n;i++){
            int temp[]=new int[m];
            for(int j=0;j<m;j++){
                int top=prev[j];
                int leftDia=Integer.MAX_VALUE;
                if(j>0 && i>0) leftDia= prev[j-1];

                int rightDia=Integer.MAX_VALUE;
                if(i>0 && j<m-1) rightDia=prev[j+1];
                temp[j]= arr[i][j] + Math.min(top,Math.min(leftDia,rightDia));

            }
            prev=temp;
        }
        int mini=Integer.MAX_VALUE;

        for(int j=0;j<m;j++){
            mini=Math.min(mini,prev[j]);
        }
        return mini;
        
    }
}