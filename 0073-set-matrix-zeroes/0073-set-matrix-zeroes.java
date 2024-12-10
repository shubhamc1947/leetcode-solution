class Solution {
    public void setZeroes(int[][] arr) {
        ArrayList<int[]> zeroIdx=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==0){
                    zeroIdx.add(new int[]{i,j});
                }
            }
        }
        for(int i=0;i<zeroIdx.size();i++){
            int curr[]=zeroIdx.get(i);
            int row= curr[0];
            int col=curr[1];

            for(int j=0;j<arr[0].length;j++){
                arr[row][j]=0;
            }
             for(int j=0;j<arr.length;j++){
                arr[j][col]=0;
            }
            
        }
        

    }
}