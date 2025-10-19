class Solution {
    public boolean check(int arr[],int mid,int m,int n){
        int currBall=arr[0];
        int count=1;
        for(int i=0;i<n;i++){
            if(arr[i]-currBall>=mid){
                currBall=arr[i];
                count++;
                if(count>=m) return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int n=arr.length;
        int si=0,ei=arr[n-1];
        int ans=ei;
        while(si<=ei){
            int mid=si+(ei-si)/2;

            if(check(arr,mid,m,n)){
                ans=mid;
                si=mid+1;
            }else{
                ei=mid-1;
            }
            System.out.println(mid+"mid "+ans);
        }
        return ans;
    }
}