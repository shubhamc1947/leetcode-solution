class Solution {

    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int ans=1;

        int temp[]=new int[n];
        for(int i=0;i<n;i++) temp[i]=i;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    if(dp[i]<dp[j]+1) {
                        dp[i]=dp[j]+1;
                        temp[i]=j;
                        ans=Math.max(dp[i],ans);

                    }
                }
            }
        }
        // find the max lcs in dp for starting index
        int stIdx=-1;
        for(int i=0;i<n;i++){
            if(dp[i]==ans){
                stIdx=i;
                break;
            }
        }

        System.out.println(stIdx);
        ArrayList<Integer> ansArr=new ArrayList<>();

        while(stIdx!=temp[stIdx]){
            ansArr.add(arr[stIdx]);
            stIdx=temp[stIdx];
        }
        ansArr.add(arr[stIdx]);
        System.out.println(ansArr);

        return ans;
    }
}