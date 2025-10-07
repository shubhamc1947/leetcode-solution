class Solution {
    public int pivotIndex(int[] arr) {
        int totSum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            totSum+=arr[i];
        }

        int leftSum=0;
        int rightSum=0;
        for(int i=0;i<n;i++){
            rightSum=totSum-arr[i]-leftSum;
            if(leftSum==rightSum){
                return i;
            }
            leftSum+=arr[i];
        }
        return -1;
    }
}