class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n=arr.length;
        int leftMulti[]=new int[n];
        leftMulti[0]=1;
        for(int i=1;i<n;i++){
            leftMulti[i]=leftMulti[i-1]*arr[i-1];
        }

        int rightMulti[]=new int[n];
        rightMulti[n-1]=1;
        for(int i=n-2;i>=0;i--){
            rightMulti[i]=rightMulti[i+1]*arr[i+1];
        }

        for(int i=0;i<n;i++){
            leftMulti[i]=leftMulti[i]*rightMulti[i];
        }
        return leftMulti;
    }
}