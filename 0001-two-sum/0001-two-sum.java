class Solution {
    public int[] twoSum(int[] arr, int tar) {
        int n=arr.length;
        //     arr[i] ,  i 
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            int comp=tar-arr[i];
            if(hm.containsKey(comp)){
                return new int[]{hm.get(comp),i};
            }else{
                hm.put(arr[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}