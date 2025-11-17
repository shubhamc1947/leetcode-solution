class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int leftMax=arr[0];
        int rightMax=arr[n-1];
        int si=0,ei=n-1;
        int sum=0;
        while(si<=ei){
            if(arr[si]<arr[ei]){
                leftMax=Math.max(leftMax,arr[si]);
                sum+=leftMax-arr[si];
                si++;
            }else{
                rightMax=Math.max(rightMax,arr[ei]);
                sum+=rightMax-arr[ei];
                ei--;
            }
        }
        return sum;
    }
}