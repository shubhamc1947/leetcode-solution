class Solution {
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public int findGCD(int[] arr) {
        int n=arr.length;
        int mini=arr[0];
        int maxi=arr[0];
        for(int i=0;i<n;i++){
            mini=Math.min(mini,arr[i]);
            maxi=Math.max(maxi,arr[i]);
        }   
        
        int res=gcd(maxi,mini);
        return res;
    }
}