class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer, Integer> hm=new HashMap<>();//remainder, freq
        hm.put(0,1);
        int prefixSum=0;
        int ans=0;
        for(int i=0;i<n;i++){
            prefixSum+=arr[i];
            int rem = ((prefixSum % k) + k) % k;
            ans += hm.getOrDefault(rem, 0);
            hm.put(rem, hm.getOrDefault(rem, 0) + 1);
        }
        return ans;

    }
}