class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);

        int n=arr.length;
        int dp[]=new int[n];
        int hash[]=new int[n];
        //inilization 
        for(int i=0;i<n;i++){
            dp[i]=1;
            hash[i]=i;
        }
        // logic
        int maxLen=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0 && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                    maxLen=Math.max(maxLen,dp[i]);
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     System.out.print(dp[i]+" ");
        // }
        // System.out.println();
        
        // for(int i=0;i<n;i++){
        //     System.out.print(hash[i]+" ");
        // }
        // System.out.println();
        
        //find the idx for starting val
        int stIdx=-1;
        for(int i=0;i<n;i++){
            if(dp[i]==maxLen){
                stIdx=i;
                break;    
            }
            
        }
        // System.out.println(maxLen);
        // now we have the idx
        ArrayList<Integer> ans=new ArrayList<>();
        while(stIdx!=hash[stIdx]){
            ans.add(arr[stIdx]);
            stIdx=hash[stIdx];
        }
        ans.add(arr[stIdx]);
        Collections.reverse(ans);
        
        return ans;
    }
}