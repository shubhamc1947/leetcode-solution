class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer, Integer> hm=new HashMap<>();//remainder, freq
        hm.put(0,1);
        int prefixSum=0;
        int ans=0;
        for(int i=0;i<n;i++){
            prefixSum+=arr[i];
            int rem = ((prefixSum % k) + k) % k;// we only need positive

            if(!hm.containsKey(rem)){
                hm.put(rem,1);
            }else{
                int currFreq=hm.get(rem);
                ans+=currFreq;
                hm.put(rem,currFreq+1);
            }
        }
        System.out.println(hm);
        return ans;

    }
}