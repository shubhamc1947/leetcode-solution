class Solution {
    public void merge(int arr[],int si,int mid,int ei){
        int left=si;
        int right=mid+1;
        int temp[]=new int[ei-si+1];
        int idx=0;
        while(left<=mid && right<=ei){
            if(arr[left]<=arr[right]){
                temp[idx++]=arr[left];
                left++;
            }else{
                temp[idx++]=arr[right];
                right++;
            }
        }
        
        while(left<=mid){
            temp[idx++]=arr[left++];
        }
        while(right<=ei){
            temp[idx++]=arr[right++];
        }

        for(int i=0;i<ei-si+1;i++){
            arr[i+si]=temp[i];
        }
    }
    public void mergeSort(int arr[],int si,int ei){
        if(si>=ei) return;
        int mid=si+(ei-si)/2;
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }
    public int[] sortArray(int[] arr) {
        mergeSort(arr,0,arr.length-1);
        return arr;
    }
}