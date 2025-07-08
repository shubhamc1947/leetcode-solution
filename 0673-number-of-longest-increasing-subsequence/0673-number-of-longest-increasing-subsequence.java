class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n];
        int cnt[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        int len=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    if(dp[i]<dp[j]+1){
                        //
                        dp[i]=dp[j]+1;
                        cnt[i]=cnt[j];// inherit the count
                    }else if(dp[i] == dp[j] + 1){
                        cnt[i]+=cnt[j];
                    }            
                }
                len=Math.max(len,dp[i]);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(dp[i]==len){
                count+=cnt[i];
            }
        }

        return count;

    }
}