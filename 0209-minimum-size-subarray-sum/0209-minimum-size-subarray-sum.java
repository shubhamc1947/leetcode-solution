class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int n=arr.length;
        int si=0,ei=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        while(ei<n){
            sum+=arr[ei];
            while(sum>=target){
                ans=Math.min(ans,ei-si+1);
                sum-=arr[si];
                si++;
            }
            ei++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}