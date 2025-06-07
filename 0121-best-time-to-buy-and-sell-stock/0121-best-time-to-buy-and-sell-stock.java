class Solution {
    public int maxProfit(int[] arr) {
        int buy=arr[0];
        int profit=Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            profit=Math.max(profit, arr[i]-buy);
            buy=Math.min(buy,arr[i]);
        }
        return profit<0?0:profit;
    }
}