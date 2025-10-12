class Solution {
    public int pivotIndex(int[] arr) {
        int n=arr.length;
        int totSum=0;
        for(int i=0;i<n;i++){
            totSum+=arr[i];
        }
        int prefixSum=0;
        
        for(int i=0;i<n;i++){
            if(prefixSum==totSum-prefixSum-arr[i]){
                return i;
            }
            prefixSum+=arr[i];
        }
        return -1;
    }
}