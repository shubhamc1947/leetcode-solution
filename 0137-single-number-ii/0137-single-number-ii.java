class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int bitIdx=0;bitIdx<=31;bitIdx++){
            int bitCount=0;
            for (int i=0;i<n;i++){
                if((nums[i] & (1<<bitIdx))!=0){
                    bitCount++;
                }
            }
            if(bitCount%3!=0){
                ans=(ans|(1<<bitIdx));
            }
        }
        return ans;
    }
}