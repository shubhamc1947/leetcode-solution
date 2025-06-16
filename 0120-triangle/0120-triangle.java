class Solution {
    
    public int minimumTotal(List<List<Integer>> arr) {
        int n=arr.size();
        int next[]=new int[n];
        //base case
        for(int j=0;j<n;j++){
            next[j]=arr.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            int curr[]=new int[n];
            for(int j=0;j<=i;j++){
                int bottom=next[j]+arr.get(i).get(j);
                int dia=next[j+1]+arr.get(i).get(j);
                curr[j]= Math.min(bottom,dia);
            }
            next=curr;
        }

        return next[0];
    }
}