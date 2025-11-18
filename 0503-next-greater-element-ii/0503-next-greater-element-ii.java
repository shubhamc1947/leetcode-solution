class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n=arr.length;
        int nge[]=new int[n];
        for(int i=0;i<n;i++){
            boolean isAns=false;
            for(int j=i+1;j<=n+i-1;j++){
                if(arr[i]<arr[j%n]){
                    nge[i]=arr[j%n];
                    isAns=true;
                    break;
                }
            }
            if(!isAns) nge[i]=-1;
        }   
        return nge;

    }
}