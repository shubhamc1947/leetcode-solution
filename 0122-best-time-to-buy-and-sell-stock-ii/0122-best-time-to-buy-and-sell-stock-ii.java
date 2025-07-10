class Solution {
  
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int next[]=new int[2];

        for(int idx=n-1;idx>=0;idx--){
            int curr[]=new int[2];
            for(int buy=0;buy<=1;buy++){
                int notTake= next[buy];

                //take
                int take=-(int)1e8;
                if(buy==0){
                        take=-arr[idx]+ next[1];
                }else{
                        take=arr[idx]+next[0];
                }
                curr[buy]= Math.max(take,notTake);
            }
            next=curr;
        }

        // n-1=>0
        
        return next[0];
    }
}