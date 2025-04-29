class Solution {
    public long countSubarrays(int[] arr, int k) {
        int n=arr.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,arr[i]);
        }

        int freq=0,left=0,rigth=0;
        long ans=0;
        while(rigth<n){
            if(arr[rigth]==maxi){
                freq++;
            }
            while(freq>=k){
                ans+=n-rigth;
                if(arr[left]==maxi){
                    freq--;
                }
                left++;
            }
            rigth++;
        }
        return ans;
    }
}