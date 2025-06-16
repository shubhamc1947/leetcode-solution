class Solution {
    public int maximumDifference(int[] arr) {
        int n=arr.length;
        int ans=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    ans=Math.max(arr[i]-arr[j],ans);
                }
            }
        }
        return ans;
    }
}