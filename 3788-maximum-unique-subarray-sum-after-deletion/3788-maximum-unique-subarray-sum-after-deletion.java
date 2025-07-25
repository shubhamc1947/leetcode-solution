
class Solution {
    public int maxSum(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        HashSet<Integer> hs=new HashSet<>();
        int sum=0;
        int onePlus=0;
        
        for(int i=0;i<nums.length;i++){
            if(hs.contains(nums[i])){
                continue;
            }
            if(nums[i]<=0){
                continue;
            }
            onePlus=1;
            hs.add(nums[i]);
            sum+=nums[i];
        }
        if(onePlus==1){
            return sum;
        }else{
            int maxi=Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                maxi=Math.max(nums[i],maxi);
            }
            return maxi;
        }
        
    }
}