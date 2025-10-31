class Solution {
    public int[] getSneakyNumbers(int[] arr) {
        Arrays.sort(arr);
        int j=0;
        int ans[]=new int[2];
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                ans[j++]=arr[i];
            }
        }
        return ans;
    }
}