class Solution {
    public int repeatedNTimes(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1]) return arr[i];
            if(i+2<n && arr[i]==arr[i+2]) return arr[i];
            if(i+3<n && arr[i]==arr[i+3]) return arr[i];
        }
        return -1;
    }
}