class Solution {
    public int maxSubArray(int[] arr) {
        int ans=Integer.MIN_VALUE;
        int curr=0;
        for(int i=0;i<arr.length;i++){
            curr+=arr[i];
            if(ans<curr){
                ans=curr;
            }
            if(curr<0){
                curr=0;
            }
        }
        return ans;
    }
}