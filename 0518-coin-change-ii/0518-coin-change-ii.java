class Solution {
    public int change(int t, int[] arr) {
        int n=arr.length;
        int prev[]=new int[t+1];

        for(int tar=0;tar<=t;tar++){
            if(tar % arr[0]==0) prev[tar]=1;
        }

        for(int idx=1;idx<n;idx++){
            int curr[]=new int[t+1];
            for(int tar=0;tar<=t;tar++){
                int notTake=0+prev[tar];
                int take=0;
                if(tar>=arr[idx]){
                    take=curr[tar-arr[idx]];
                }
                curr[tar]= take+notTake;
            }
            prev=curr;
        }
        return prev[t];
    }
}