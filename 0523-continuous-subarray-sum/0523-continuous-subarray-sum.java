class Solution {
    public boolean checkSubarraySum(int[] arr, int k) {
        // remainder, index (map)
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=arr.length;
        int currSum=0;
        hm.put(0,-1);
        for(int i=0;i<n;i++){
            currSum+=arr[i];
            if(!hm.containsKey(currSum % k)){
                hm.put(currSum%k, i);
            }else if(i-hm.get(currSum%k)>1){
                return true;
            }
        }
        return false;
    }
}