class Solution {
    public int findMax(int arr[]){
        int n=arr.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
           maxi=Math.max(maxi,arr[i]);
        }
        return maxi;
    }
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        //i th index shows till 
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }

        return findMax(dp);
    }
}