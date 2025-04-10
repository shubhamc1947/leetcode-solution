class Solution {
    public int searchInsert(int[] arr, int tar) {
        //binary approch and better approch
        
        int ans=arr.length;
        int si=0,ei=arr.length-1;
        while(si<=ei){
            int mid=ei-(ei-si)/2;
            if(arr[mid]==tar){
                return mid;

            }else if(arr[mid]<tar){
                si=mid+1;
            }else{
                ans=mid;
                ei=mid-1;
            }
        }
        return ans;
    }
}