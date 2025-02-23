class Solution {
    public int climbStairs(int n) {
        if(n<0) return -1;
        if(n==0 || n==1) return 1;
        int nm1=1;
        int nm2=1;
        int ans=0;
        for(int i=2;i<=n;i++){
            ans=nm1+nm2;
            nm2=nm1;
            nm1=ans;
        }
        return ans;
    }
}