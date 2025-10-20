class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n=arr.length;
        int prefixMulti[]=new int[n];
        prefixMulti[0]=1;
        for(int i=1;i<n;i++){
            prefixMulti[i]=prefixMulti[i-1]*arr[i-1];
        }
        int suffixMulti=arr[n-1];
        for(int i=n-2;i>=0;i--){
            prefixMulti[i]=suffixMulti*prefixMulti[i];
            suffixMulti*=arr[i];
        }
        return prefixMulti;
    }
}