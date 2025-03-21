class Solution {
    public int majorityElement(int[] nums) {
        int ans=nums[0];
        int freq=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==ans){
                freq++;
            }else{
                freq--;
                if(freq==0){
                    ans=nums[i];
                    freq++;
                    // System.out.println(nums[i]);
                }
            }
        }
        return ans;
    }
}