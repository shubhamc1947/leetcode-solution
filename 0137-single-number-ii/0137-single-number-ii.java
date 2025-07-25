class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=1;i<n-1;i=i+3){
            if((nums[i-1]==nums[i]) && (nums[i]==nums[i+1])){
                // System.out.println(nums[i]+" "+i);
                continue;

            }else{
                // System.out.println(nums[i]+" "+i);

                return nums[i-1];
            }
        }
        return nums[n-1];
    }
}