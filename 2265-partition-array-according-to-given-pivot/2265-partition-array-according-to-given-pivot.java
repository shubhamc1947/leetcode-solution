class Solution {
    public int[] pivotArray(int[] nums, int pivot){
        int n=nums.length;
		int less[]=new int[n];	
		int j=0;
		for(int i=0;i<n;i++){
			if(nums[i]<pivot){
				less[j++]=nums[i];
			}
		}
		for(int i=0;i<n;i++){
			if(nums[i]==pivot){
				less[j++]=pivot;
			}
		}
		for(int i=0;i<n;i++){
			if(nums[i]>pivot){
				less[j++]=nums[i];
			}
		}
				
		return less;
    }
}