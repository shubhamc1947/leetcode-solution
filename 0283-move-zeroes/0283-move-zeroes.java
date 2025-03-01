class Solution {
    public void moveZeroes(int[] arr) {
        int si=-1;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==0 && si==-1){
                si=i;
                
            }
            if(arr[i]!=0 && si!=-1){
                //swap
                int temp=arr[si];
                arr[si]=arr[i];
                arr[i]=temp;
                si++;
            }
        }
    }
}