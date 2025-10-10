class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n=arr.length;
        int prefix[]=new int[n];
        prefix[0]=1;
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]*arr[i-1];
        }
        int postfix=arr[n-1];
        for(int i=n-2;i>=0;i--){
            prefix[i]=prefix[i]*postfix;

            postfix=postfix*arr[i];
        }
        return prefix;
    }
}