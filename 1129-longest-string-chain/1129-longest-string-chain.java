class Solution {
    public boolean comp(String s1,String s2){
        int n1=s1.length();
        int n2=s2.length();
        if(n1!=n2+1){
            return false;
        }
        int j=0;
        int i=0;
        for(;i<n1;){
            if(j<n2&&s1.charAt(i)==s2.charAt(j)){
                j++;
                i++;
            }else{
                i++;
            }
        }
        return i==n1 && j==n2;

    }
    public int longestStrChain(String[] arr) {
        int n=arr.length;
        int ans=1;

        int dp[]=new int[n];
        Arrays.fill(dp,1);

        Arrays.sort(arr,(a,b)->a.length()-b.length()); //sort with the comparator 
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(comp(arr[i],arr[j]) && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    ans=Math.max(ans,dp[i]);
                }
            }
        }
        return ans;
    }
}