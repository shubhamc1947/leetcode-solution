class Solution {
    public int helper(int arr[],int n){
        int prev2=arr[0];
        int prev1=Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            int take=arr[i]+prev2;
            int notTake=0+prev1;
            int curr=Math.max(take,notTake);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        int arr[]=new int[n-1];
        int brr[]=new int[n-1];
        for(int i=0;i<n-1;i++){
            arr[i]=nums[i];
            brr[i]=nums[i+1];
        }

        int firstSituation=helper(arr,n-1);
        int secondSituation=helper(brr,n-1);
        return Math.max(firstSituation,secondSituation);

    }
}