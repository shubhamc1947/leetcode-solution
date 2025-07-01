class Solution {
 
    public int minimumTotal(List<List<Integer>> arr) {
        int n=arr.size();
        int prev[]=new int[n];
        for(int j=0;j<n;j++){
            prev[j]=arr.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            int curr[]=new int[n];
            for(int j=0;j<=i;j++){
                int bottom=arr.get(i).get(j)+prev[j];
                int dia=arr.get(i).get(j)+prev[j+1];
                curr[j]= Math.min(bottom,dia);
            }
            prev=curr;
        }
        return prev[0];
    }
}