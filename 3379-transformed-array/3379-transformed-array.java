class Solution {
    public int[] constructTransformedArray(int[] arr) {
        int n=arr.length;
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            int idx=(i+arr[i])%n;
            if(idx<0){
                idx+=n;
            }
            res[i]=arr[idx];
        }
        return res;
    }
}