class Solution {
    public int pivotIndex(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            int left=0;
            int right=0;
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }else if(j<i){
                    left+=arr[j];
                }else{
                    right+=arr[j];
                }
            }
            if(left==right) return i;
        }
        return -1;
    }
}