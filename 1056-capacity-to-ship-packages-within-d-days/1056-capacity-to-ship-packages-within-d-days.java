class Solution {
    public boolean check(int arr[],int wt,int d,int n){

        int currd=1;
        int currWt=0;
        for(int i=0;i<n;i++){
            if(currWt+arr[i]>wt){
                currd++;
                currWt=arr[i];
                if(currd>d){
                    return false;
                }
            }else{
                currWt+=arr[i];
            }
        }
        
        return true;
    }
    public int shipWithinDays(int[] arr, int d) {
        int n=arr.length;
        int si=0,ei=0;
        for(int i=0;i<n;i++){
            ei+=arr[i];
            si=Math.max(si,arr[i]);
        }
        int ans=ei;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(check(arr,mid,d,n)){
                ans=mid;
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        return ans;
    }
}