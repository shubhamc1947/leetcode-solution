class Solution {
    public boolean check(int arr[],int mid,int n,int k){
        int currSum=arr[0];
        int count=1;

        for(int i=1;i<n;i++){
            if(arr[i]+currSum>mid){
                currSum=arr[i];
                count++;
                if(count>k){
                    return false;
                }
            }else{
                currSum+=arr[i];
            }
        }
        return true;
    }
    public int splitArray(int[] arr, int k) {
        int n=arr.length;
        int si=arr[0],ei=arr[0];
        for(int i=1;i<n;i++){
            si=Math.max(si,arr[i]);
            ei+=arr[i];
        }
        int ans=ei;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(check(arr,mid,n,k)){
                ans=mid;
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        return ans;
    }
}