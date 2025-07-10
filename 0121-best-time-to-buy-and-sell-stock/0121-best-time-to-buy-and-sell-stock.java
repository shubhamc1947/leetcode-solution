class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int buy=arr[0];
        int profit=-(int)1e8;
        for(int i=1;i<n;i++){
            profit=Math.max(profit,arr[i]-buy);
            buy=Math.min(buy,arr[i]);
            
        }
        return profit<0?0:profit;
    }
}