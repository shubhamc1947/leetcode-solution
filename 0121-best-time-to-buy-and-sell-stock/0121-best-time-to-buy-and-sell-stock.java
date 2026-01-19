class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int profit=-(int)1e8;
        int mini=arr[0];
        for(int i=1;i<n;i++){
            profit=Math.max(profit,arr[i]-mini);
            mini=Math.min(mini,arr[i]);
        }
        return profit<0?0:profit;
    }
}