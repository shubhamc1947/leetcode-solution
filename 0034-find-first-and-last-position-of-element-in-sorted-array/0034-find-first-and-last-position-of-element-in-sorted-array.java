class Solution {
    public int[] searchRange(int[] arr, int tar) {
        int si=0;
        int ei=arr.length-1;
        int ans[]=new int[]{-1,-1};
        // left index leke aayge ye
        while(si<=ei){
            int mid=ei-(ei-si)/2;
            if(arr[mid]==tar){
                ans[0]=mid;
                ei=mid-1;
            }else if(arr[mid]>tar){
                ei=mid-1;
            }else{
                si=mid+1;
            }

        }
        //right index leke aayega ye
        si=0;
        ei=arr.length-1;
        while(si<=ei){
            int mid=ei-(ei-si)/2;
            if(arr[mid]==tar){
                ans[1]=mid;
                si=mid+1;
            }else if(arr[mid]>tar){
                ei=mid-1;
            }else{
                si=mid+1;
            }

        }
        return ans;
    }
}