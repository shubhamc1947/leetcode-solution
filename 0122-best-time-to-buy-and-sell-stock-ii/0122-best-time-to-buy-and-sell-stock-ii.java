class Solution {
    
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int prev[]=new int[2];// one extra for base case 
        //base case 
        prev[0]=prev[1]=0;//no need by default but added
        for(int idx=n-1;idx>=0;idx--){
            int curr[]=new int[2];
            for(int j=0;j<2;j++){
                if(j==1){
                    //either sell here 
                    int currSell=arr[idx]+prev[0];
                    // or don't sell here
                    int notSell=prev[1];
                    curr[j]= Math.max(currSell,notSell);
                }else{// buy==0
                    // either buy here
                    int currBuy=-arr[idx]+prev[1];
                    int notBuy=prev[0];
                    curr[j]= Math.max(currBuy,notBuy);
                }
            }
            prev=curr;
        }
        return prev[0];
    }
}