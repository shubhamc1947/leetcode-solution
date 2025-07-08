class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        //similar to longest increasing subsequence
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);// minium is 1
        int temp[]=new int[n];
        for(int i=0;i<n;i++) temp[i]=i;

        int ans=1;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        ans=Math.max(ans,dp[i]);
                        temp[i]=j;
                    }
                }
            }
        }

        //find max ele from the dp (ans) we need to start from that index 
        int stIdx=-1;
        for(int i=0;i<n;i++){
            if(dp[i]==ans) {
                stIdx=i;
                break;
            }
        }
        List<Integer> ansArr=new ArrayList<>();
        while(stIdx!=temp[stIdx]){
            ansArr.add(arr[stIdx]);
            stIdx=temp[stIdx];
        }
        ansArr.add(arr[stIdx]);
        return ansArr;

    }
}