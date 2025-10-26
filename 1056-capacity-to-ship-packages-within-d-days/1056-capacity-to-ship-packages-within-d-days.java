class Solution {
    public boolean check(int arr[],int days,int mid,int n){
        int curr=arr[0];
        int count=1;
        for(int i=1;i<n;i++){
            if(curr+arr[i]>mid){
                count++;
                curr=arr[i];
                if(count>days){
                    return false;
                }
            }else{
                curr+=arr[i];
            }
        }
        return true;
    }
    public int shipWithinDays(int[] arr, int days) {
        int n=arr.length;
        int si=arr[0];
        int ei=arr[0];
        for(int i=1;i<n;i++){
            si=Math.max(si,arr[i]);
            ei+=arr[i];
        }
        int ans=ei;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(check(arr,days,mid,n)){
                ei=mid-1;
                ans=mid;
            }else{
                si=mid+1;
            }
        }
        return ans;
    }
}