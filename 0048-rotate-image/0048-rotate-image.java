class Solution {
    public void trans(int arr[][]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }

    public void rotate(int[][] arr) {
        int n=arr.length;
        trans(arr);
        for(int i=0;i<n;i++){
            int si=0,ei=n-1;
            while(si<=ei){
                int temp=arr[i][si];
                arr[i][si]=arr[i][ei];
                arr[i][ei]=temp;
                si++;
                ei--;
            }
        }

    }
}