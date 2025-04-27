class Solution {
    
    public int minimumTotal(List<List<Integer>> arr) {
        int n=arr.size();
        int m=arr.get(n-1).size();

        int dp[]=new int[m];
        
        //base case
        for(int j=0;j<m;j++){
            dp[j]=arr.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            int curr[]=new int[i+1];
            for(int j=i;j>=0;j--){
                int bottom=dp[j]+arr.get(i).get(j);
                int dia=dp[j+1]+arr.get(i).get(j);
                curr[j]=Math.min(bottom,dia);
            }
            dp=curr;
        }
        return dp[0];
    }
}