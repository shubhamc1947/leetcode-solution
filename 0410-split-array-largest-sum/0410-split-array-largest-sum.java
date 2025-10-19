class Solution {
    public boolean check(int arr[],int maxiSum,int k,int n){
        int currSum=arr[0];
        int count=1;
        for(int i=1;i<n;i++){
            if(currSum+arr[i]>maxiSum){
                count++;
                currSum=arr[i];
                if(count>k) return false;
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
        int ans=arr[0];
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(check(arr,mid,k,n)){
                ans=mid;
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        return ans;
    }
}