class Solution {
    public boolean checkSubarraySum(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer,Integer> hm=new HashMap<>(); // remainder, index
        hm.put(0,-1);
        int prefixSum=0;
        for(int i=0;i<n;i++){
            prefixSum+=arr[i];

            if(hm.containsKey(prefixSum%k)){
                if(i-hm.get(prefixSum%k)>=2){
                    return true;
                }
            }else{
                hm.put(prefixSum%k,i);
            }
        }
        return false;
    }
}