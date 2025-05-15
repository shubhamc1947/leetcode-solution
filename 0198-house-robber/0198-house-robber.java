class Solution {
    public int rob(int[] arr) {
        int n=arr.length;
        //base case
        if(n==1) return arr[0];
        if(n==2) return Math.max(arr[0],arr[1]);

        int dp[]=new int[n];

        //initilizatino 
        int secondLast=arr[0];
        int firstLast=Math.max(arr[0],arr[1]);

        for(int i=2;i<n;i++){
            int take=secondLast+arr[i];
            int notTake=firstLast+0;
            int curr=Math.max(take,notTake);
            secondLast=firstLast;
            firstLast=curr;
        }
        return firstLast;
    }
}