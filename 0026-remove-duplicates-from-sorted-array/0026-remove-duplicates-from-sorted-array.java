class Solution {
    public int removeDuplicates(int[] arr) {
        int j=0;
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[j]!=arr[i]){
                j++;
                arr[j]=arr[i];
            }
        }
        return j+1;
    }
}