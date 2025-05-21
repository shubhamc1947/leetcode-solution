class Solution {
    public void setZeroes(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int rowTrack[]=new int[n];
        int colTrack[]=new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    rowTrack[i]=-1;
                    colTrack[j]=-1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rowTrack[i]==-1 || colTrack[j]==-1){
                    arr[i][j]=0;
                }
            }
        }
    }
}