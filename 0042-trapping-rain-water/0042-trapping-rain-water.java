class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int maxLeft=arr[0];
        int maxiRight=arr[n-1];
        int si=0,ei=n-1;
        int sum=0;
        while(si<=ei){
            if(arr[si]<arr[ei]){
                //left side 
                maxLeft=Math.max(maxLeft,arr[si]);
                sum+=maxLeft-arr[si];
                si++;
            }else{
                maxiRight=Math.max(maxiRight,arr[ei]);
                sum+=maxiRight-arr[ei];
                ei--;
            }
        }
        return  sum;
    }
}