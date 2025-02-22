class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] newNums = new int[nums1.length + nums2.length];
        for(int i=0; i<nums1.length; i++){
            newNums[i] = nums1[i]; 
        }
        for(int i=0; i<nums2.length; i++){
            newNums[nums1.length + i] = nums2[i]; 
        }

        Arrays.sort(newNums);
        int n = newNums.length;
        
        if(newNums.length%2 != 0){
            return newNums[n/2];
        }
        else{
            double first = newNums[(n/2)-1];
            double sec = newNums[n/2];
            double mid = (first+sec)/2;
            return mid;
        }
    }
}