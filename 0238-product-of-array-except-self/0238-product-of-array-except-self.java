class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n=arr.length;
        int prefixMulti[]=new int[n];
        prefixMulti[0]=1;
        
        for(int i=1;i<n;i++){
            prefixMulti[i]=prefixMulti[i-1]*arr[i-1];
        }
        int postfixMulti[]=new int[n];
        postfixMulti[n-1]=1;
        for(int i=n-2;i>=0;i--){
            postfixMulti[i]=postfixMulti[i+1]*arr[i+1];
        }

        for(int i=0;i<n;i++){
            postfixMulti[i]=postfixMulti[i]*prefixMulti[i];
        }

        return postfixMulti;
    }
}