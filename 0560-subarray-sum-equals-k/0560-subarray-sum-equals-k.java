class Solution {
    public int subarraySum(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer, Integer> hm=new HashMap<>();
        hm.put(0,1);
        int sum=0;
        int ans=0;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
            if(hm.containsKey(sum-k)){
                ans+=hm.get(sum-k);
            }
            if(hm.containsKey(sum)){
                hm.put(sum,hm.get(sum)+1);
            }else{
                hm.put(sum,1);
            }
        }
        return ans;
    }
}