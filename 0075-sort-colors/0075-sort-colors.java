class Solution {
    public void sortColors(int[] arr) {
        int i=0,j=0,k=arr.length-1;
        while(j<=k){
            if(arr[j]==0){
                //swap j and i th idx
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;j++;
            }else if(arr[j]==2){
                //swap jth and kth idx
                int temp=arr[j];
                arr[j]=arr[k];
                arr[k]=temp;
                k--;
            }else{
                j++;
            }
           
        }
    }
}