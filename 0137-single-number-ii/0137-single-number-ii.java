class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }
        }
        
        for(int curr: hm.keySet()){
            if(hm.get(curr)==1){
                return curr;
            }
        }
        return -1;
    }
}