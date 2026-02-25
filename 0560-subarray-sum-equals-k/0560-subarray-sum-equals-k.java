class Solution {
    public int subarraySum(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer, Integer> hm=new HashMap<>();
        // storing sum, freq 
        hm.put(0,1);
        int ans=0;
        int prefixSum=0;
        for(int i=0;i<n;i++){
            prefixSum+=arr[i];
            if(hm.containsKey(prefixSum-k)){
                ans=ans+hm.get(prefixSum-k);
            }

            hm.put(prefixSum,hm.getOrDefault(prefixSum,0)+1);
        }
        return ans;
    }
}