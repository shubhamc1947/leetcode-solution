class Solution {
    public int countNegatives(int[][] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=arr[i].length-1;j>=0;j--){
                if(arr[i][j]>=0){
                    break;
                }else{
                    sum++;
                }
            }
        }
        return sum;
    }
}