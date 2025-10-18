class Solution {
    public int search(int[] arr, int target) {
        int n=arr.length;
        int si=0,ei=n-1;
        while(si<=ei){
            int mid=si+((ei-si)/2);
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        return -1;
    }
}