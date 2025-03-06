class Solution {
    public int findPeakElement(int[] arr) {
        int n=arr.length;
        int si=0,ei=n-1;
        while(si<=ei){
            int mid=si-(si-ei)/2;
            if((mid==0||arr[mid]>arr[mid-1])&&(mid==n-1||arr[mid]>arr[mid+1])){
                return mid;
            }else if(mid>0 && arr[mid]<arr[mid-1]){
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        return -1;
    }
}
