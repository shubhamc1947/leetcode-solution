class Solution {
    public int removeDuplicates(int[] nums) {
        int si=0;
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[si]){
                nums[i]=-10000;
                count++;
            }else{
                si=i;
            }
        }
        int zeroIdx=-10000;
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");

        }
        System.out.println();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=-10000){
                if(zeroIdx!=-10000){
                    nums[zeroIdx]=nums[i];
                    nums[i]=-10000;
                    zeroIdx++;
                }
            }else if(zeroIdx==-10000){
                zeroIdx=i;
            }
        }
        return nums.length-count;
        
    }
}