class Solution {
    public void transpose(int [][] arr,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        transpose(matrix,n);

        for(int i=0;i<n;i++){
            int si=0;
            int ei=n-1;
            while(si<ei){
                int temp=matrix[i][si];
                matrix[i][si]=matrix[i][ei];
                matrix[i][ei]=temp;
                si++;
                ei--;
            }
        }

    }
}