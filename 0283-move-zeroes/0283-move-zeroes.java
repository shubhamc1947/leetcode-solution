class Solution {
    public void moveZeroes(int[] arr) {
        int zeroIdx=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0 ){
                if(zeroIdx !=-1){
                    arr[zeroIdx]=arr[i];
                    arr[i]=0;
                    zeroIdx++;
                }
               
            }else if(zeroIdx==-1){
                zeroIdx=i;
            }
        }
    }
}