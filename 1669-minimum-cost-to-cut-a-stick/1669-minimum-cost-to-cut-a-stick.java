class Solution {
    public int func(ArrayList<Integer> arr,int i,int j,int dp[][]){
        if(i>j) return 0;
        int small=Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int x=i;x<=j;x++){
            int curr=arr.get(j+1)-arr.get(i-1)+func(arr,i,x-1,dp)+func(arr,x+1,j,dp);
            small=Math.min(small,curr);
        }
        return dp[i][j]=small;
    }
    public int minCost(int n, int[] cuts) {
        int cutsLen=cuts.length;
        Arrays.sort(cuts);
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(0);
        for(int i=0;i<cuts.length;i++){
            arr.add(cuts[i]);
        }
        arr.add(n);
        int dp[][]=new int[cutsLen+1][cutsLen+1];
        for(int i=0;i<=cutsLen;i++) Arrays.fill(dp[i],-1);
        return func(arr,1,cutsLen,dp);
    }
}