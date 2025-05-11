class Solution {
    public void reverseArr(int arr[],int si,int ei){
        while(si<ei){
            int temp=arr[si];
            arr[si]=arr[ei];
            arr[ei]=temp;
            si++;
            ei--;
        }
    }
    public void rotate(int[] arr, int k) {
        int n=arr.length;
        k=k%n;
        reverseArr(arr,0,n-1);
        reverseArr(arr,0,k-1);
        reverseArr(arr,k,n-1);

    }
}