class Solution {
    public int[] twoSum(int[] arr, int tar) {
        int n=arr.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        int ans[]=new int[]{-1,-1};
        for(int i=0;i<n;i++){
            if(hm.containsKey(tar-arr[i])){
                ans[0]=hm.get(tar-arr[i]);
                ans[1]=i;
                return ans;
            }else{
                hm.put(arr[i],i);
            }
        }
        return ans;
    }
}