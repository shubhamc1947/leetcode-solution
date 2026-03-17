class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int si=0;
        int ei=n-1;
        int leftMax=arr[si];
        int rigthMax=arr[ei];
        int ans=0;
        while(si<=ei){
            if(arr[si]<arr[ei]){
                leftMax=Math.max(leftMax,arr[si]);
                ans+=leftMax-arr[si];
                si++;
            }else{
                rigthMax=Math.max(rigthMax,arr[ei]);
                ans+=rigthMax-arr[ei];
                ei--;
            }
        }
        return ans;
    }
}