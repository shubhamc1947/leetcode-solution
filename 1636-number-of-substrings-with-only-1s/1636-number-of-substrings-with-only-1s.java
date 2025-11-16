class Solution {
    int mod=(int)1e9+7;
    public int numSub(String s) {
        int n=s.length();

        long totalCount=0, count=0;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i)=='1') count=(count+1)%mod;
            else count=0;
            totalCount=(totalCount+count)%mod;
        }
        return (int)totalCount%mod;
    }
}