class Solution {
    public int rob(int[] arr) {
        int n=arr.length;
        int prev2=0;
        int prev=arr[0];
        
        for(int i=1;i<n;i++){
            
            int take=arr[i];
            if(i>1) take+=prev2;

            int notTake=0+prev;

            int curri=Math.max(take,notTake);
            prev2=prev;
            prev=curri;
        }
        return prev;
    }
}