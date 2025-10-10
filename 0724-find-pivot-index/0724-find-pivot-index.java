class Solution {
    public int pivotIndex(int[] arr) {
        int n=arr.length;
        int prefixSum[]=new int[n];
        prefixSum[0]=arr[0];

        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+arr[i];
        }

        for(int i=0;i<n;i++){
            if(prefixSum[i]-arr[i]== prefixSum[n-1]-prefixSum[i]){
                return i;
            }
        }
        return -1;


    }
}