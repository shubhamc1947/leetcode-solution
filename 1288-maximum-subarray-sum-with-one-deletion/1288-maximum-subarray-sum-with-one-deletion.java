class Solution {
    public int maximumSum(int[] arr) {
        int curr=arr[0],currSkip=0,ans=arr[0];
        for(int i=1;i<arr.length;i++){
            currSkip=Math.max(currSkip+arr[i],curr);
            curr=Math.max(curr+arr[i],arr[i]);

            ans=Math.max(ans,Math.max(curr,currSkip));
        }
        return ans;
    }
}