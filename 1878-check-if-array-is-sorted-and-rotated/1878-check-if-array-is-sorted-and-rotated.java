class Solution {

// To check if the array is sorted and then rotated, I thought about how a sorted array behaves: all elements are in ascending order.
// If it’s rotated, there might be one place where the order breaks (i.e., an element is greater than the next).
// So, I counted how many such "breaks" occur in the circular array.
    public boolean check(int[] nums) {
        int n=nums.length;
        int count=0;
        for (int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]){
                count++;
            }
        }
        if (count<=1){
            return true;}
        else{
            return false;
        }
    }
}