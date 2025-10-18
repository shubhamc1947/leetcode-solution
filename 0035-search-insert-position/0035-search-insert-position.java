class Solution {
    public int searchInsert(int[] arr, int tar) {
        int si=0,ei=arr.length-1;
        int ans=ei+1;
        while(si<=ei){
            int mid=si+((ei-si)/2);

            if(arr[mid]==tar){
                return mid;
            }else if(arr[mid]>tar){
                ans=mid;
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        return ans;

    }
}