class Solution {
    public int[] twoSum(int[] arr, int tar) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(tar-arr[i])){
                return new int[]{hm.get(tar-arr[i]),i};
            }else{
                hm.put(arr[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
