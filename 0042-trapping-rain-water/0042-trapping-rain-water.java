class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int lnm[]=new int[n];
        int rnm[]=new int[n];
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>maxi) maxi=arr[i];

            lnm[i]=maxi;
        }

        maxi=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>maxi) maxi=arr[i];

            rnm[i]=maxi;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.min(lnm[i],rnm[i])-arr[i];
        }
        return sum;
    }
}