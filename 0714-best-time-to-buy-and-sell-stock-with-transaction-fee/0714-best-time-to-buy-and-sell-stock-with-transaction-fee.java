class Solution {
    public int maxProfit(int[] arr, int fee) {
        int n=arr.length;

        int ahead[]=new int[2];
        
        for(int idx=n-1;idx>=0;idx--){
            int curr[]=new int[2];
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    //sell
                    int currSell=arr[idx]-fee+ ahead[0];
                    int notSell= ahead[1];
                    curr[buy] = Math.max(currSell,notSell);
                }else{//0
                    //buy
                    int currBuy=-arr[idx]+ ahead[1];
                    int notBuy=ahead[0];
                    curr[buy] = Math.max(currBuy,notBuy);
                }
            }
            ahead=curr;
        }
        return ahead[0];
    }
}