class Solution {

    public int maxProfit(int k, int[] arr) {
        int n=arr.length;
        int next[][]=new int[2][k+1];
        for(int idx=n-1;idx>=0;idx--){
            int curr[][]=new int[2][k+1];
            for(int buy=0;buy<2;buy++){
                for(int cap=k;cap>0;cap--){
                    if(buy==1){//we can sell
                        int currSell=arr[idx]+next[0][cap-1];
                        int notSell=0+ next[1][cap];
                        curr[buy][cap]= Math.max(currSell,notSell);
                    }else{//buy =0
                        // System.out.println(cap);
                        int currBuy=-arr[idx]+next[1][cap];
                        int notBuy =next[0][cap];
                        curr[buy][cap]= Math.max(currBuy,notBuy);
                    }
                }
            }
            next=curr;
        }
        return next[0][k];
    }
}