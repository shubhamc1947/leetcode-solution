class Solution {
    public int[] twoSum(int[] arr, int tar) {
        int n=arr.length;
        int ans[]=new int[]{-1,-1};
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==tar){
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }
        }
        return ans;
    }
}