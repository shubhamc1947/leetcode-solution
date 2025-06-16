class Solution {
    public static void printArr(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
    public int func(int arr[],int idx,int dp[]){
        if(idx==0) return arr[0];
        if(idx==1) return Math.max(arr[0],arr[1]);
        if(dp[idx]!=-1) return dp[idx];
        int take=func(arr,idx-2,dp)+arr[idx];
        int notTake=func(arr,idx-1,dp)+0;
        return dp[idx]= Math.max(take,notTake);
    }
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        if(n==2) return Math.max(arr[0],arr[1]);
        
        int takeFirstEle[]=new int[n-1];
        int takeLastEle[]=new int[n-1];

        for(int i=0;i<n-1;i++){
            takeFirstEle[i]=arr[i];
            takeLastEle[i]=arr[i+1];
        }



        int dp[]=new int[n-1];
        Arrays.fill(dp,-1);
        // printArr(takeFirstEle);
        // printArr(takeLastEle);
        int firstOne=func(takeFirstEle,n-2,dp);
        Arrays.fill(dp,-1);
        int lastOne=func(takeLastEle,n-2,dp);
        return Math.max(firstOne,lastOne);

    }
}