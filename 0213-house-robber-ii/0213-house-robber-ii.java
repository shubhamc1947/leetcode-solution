class Solution {
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1){
            return arr[0];
        }else if(n==2){
            return Math.max(arr[0],arr[1]);
        }

        //step 1 , breaking into two differ arr
        int arr1[]=new int[n-1];
        int arr2[]=new int[n-1];
        int len1=n-1;
        int len2=n-1;
        for(int i=0;i<n-1;i++){
            arr1[i]=arr[i];
            arr2[i]=arr[i+1];
        }

        // now let's consider the answer for these two in the optimize wayonly
        //first arr
        int prev2=arr1[0];
        int prev1=Math.max(arr1[0],arr1[1]);
        
        for(int idx=2;idx<len1;idx++){
            int take=arr1[idx]+prev2;
            int notTake=0+prev1;
            int curr=Math.max(take,notTake);

            prev2=prev1;
            prev1=curr;
        }

        int ans=prev1;

        //second arr
        prev2=arr2[0];
        prev1=Math.max(arr2[0],arr2[1]);
        for(int idx=2;idx<len2;idx++){
            int take=arr2[idx]+prev2;
            int notTake=0+prev1;
            int curr=Math.max(take,notTake);
            prev2=prev1;
            prev1=curr;
        }

        return Math.max(ans,prev1);
    }
}