class Solution {
    //One Based indexing solution
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int prev[]=new int[m+1];        
        prev[0]=1;
        //default zero so no need 
        // for(int j=1;j<=m;j++){
        //     dp[0][j]=0;
        // }
        for(int i=1;i<=n;i++){
            int curr[]=new int[m+1];
            curr[0] = 1;// base case 
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    //
                    int take=prev[j-1];//take the current char from s
                    int notTake=prev[j];//dont take the current char from s
                    curr[j]= take+notTake;
                }else{
                    // don't Take
                    curr[j]=prev[j];
                }
            }
            prev=curr;
        }
        return prev[m];
    }
}