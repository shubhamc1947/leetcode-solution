class Solution {
    public int minimumDifference(int[] arr, int k) {
        int n=arr.length;
        Arrays.sort(arr);
        int ans=arr[k-1]-arr[0];

        for(int i=0;i+k<=n;i++){
            ans=Math.min(ans,arr[i+k-1]-arr[i]);
        }

        return ans;

    }
}