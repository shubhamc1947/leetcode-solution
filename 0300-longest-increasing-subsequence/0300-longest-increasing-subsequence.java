class Solution {

    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int next[]=new int[n+1];

        for(int idx=n-1;idx>=0;idx--){
            int curr[]=new int[n+1];
            for(int prev=idx-1;prev>=-1;prev--){

                int notTake=0+next[prev+1];
                //take
                int take=0;
                if(prev==-1 || arr[idx]>arr[prev]){
                    take=1+ next[idx+1];
                }
                curr[prev+1]=Math.max(take,notTake);
            }
            next=curr;
        }
        return next[-1+1];
    }
}