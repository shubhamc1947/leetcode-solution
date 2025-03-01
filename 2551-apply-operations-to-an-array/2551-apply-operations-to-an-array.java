class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }
        int si=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && si==-1){
                si=i;
            }
            if(nums[i]!=0 && si!=-1){
                int temp=nums[i];
                nums[i]=nums[si];
                nums[si]=temp;
                si++;
            }
        }
        return nums;
    }
}