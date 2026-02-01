class Solution {
    
    public int minimumCost(int[] arr) {
        int n=arr.length;
        int first=arr[0];
        Arrays.sort(arr,1,n);
        return first+arr[1]+arr[2];
    }
}