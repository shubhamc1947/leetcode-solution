class Solution {
    public int lengthOfLIS(int[] arr) {
        //recursive approch
        int n=arr.length;
        int next[]=new int[n+1];

        for(int idx=n-1;idx>=0;idx--){
            int curr[]=new int[n+1];
            for(int prev=-1;prev<n;prev++){
                int notTake= next[prev+1];

                int take=-(int)1e8;
                if(prev==-1 || arr[idx]>arr[prev]){
                    take=1+ next[idx+1];
                }
                curr[prev+1]= Math.max(take,notTake);

            }
            next=curr;
        }
        return next[-1+1];
        
    }
}