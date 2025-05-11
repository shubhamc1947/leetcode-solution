class Solution {
    public boolean searchMatrix(int[][] arr, int tar) {
        int n=arr.length,m=arr[0].length;
        int si=0,ei=m-1;
        while(si<n && ei>=0){
            if(arr[si][ei]==tar){
                return true;
            }else if(arr[si][ei]<tar){
                si++;
            }else {
                ei--;
            }
        }
        return false;
    }
}