class Solution {
    public int pivotIndex(int[] arr) {
        int totSum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            totSum+=arr[i];
        }
        int prefixSum=0;
        for(int i=0;i<n;i++){
            prefixSum+=arr[i];
            if(prefixSum-arr[i]==totSum-prefixSum){
                return i;
            }
        }
        return -1;
    }
}