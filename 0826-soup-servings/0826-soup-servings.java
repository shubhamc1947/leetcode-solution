class Solution {

    public double solve(int a[],int b[],int A,int B,double dp[][])
    {
        if(A<=0&&B<=0)
        {
            return 0.5;
        }

        if(A<=0)
        {
            return 1;
        }
        if(B<=0)
        return 0;
        if(dp[A][B]!=-1)
        return dp[A][B];
        double ans=0;

        for(int i=0;i<4;i++)
        {
            ans+=solve(a,b,A-a[i],B-b[i],dp);
        }
        return dp[A][B]=0.25*ans;
    }

    public double soupServings(int n) 
    {
        if(n>=5000)  // as the N increases the probability of emptying the B approaches to ZERO why?? 
                    //  because we have no option to pour 100 ml from B but we have option for A
        return 1;

        double dp[][]=new double[n+1][n+1];
        for(double temp[]:dp)
        {
            Arrays.fill(temp,-1);
        }
        int a[]={100,75,50,25};
        int b[]={0,25,50,75};

        return solve(a,b,n,n,dp);
        
    }
}