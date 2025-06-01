class Solution {
    public int lcs(String s1, String s2) {
        // code here
        int n1=s1.length();
        int n2=s2.length();
        int prev[]=new int[n2+1];
        
        for(int idx1=1;idx1<=n1;idx1++){
            int curr[]=new int[n2+1];
            for(int idx2=1;idx2<=n2;idx2++){
                if(s1.charAt(idx1-1)==s2.charAt(idx2-1)){
                    curr[idx2]= 1+prev[idx2-1];
                }else{
                    curr[idx2]= Math.max(prev[idx2],curr[idx2-1]); 
                }
            }
            prev=curr;
        }
        return prev[n2];
        
    }
    public int minDistance(String s1, String s2) {
        int lcs=lcs(s1,s2);
        int deletion1=s1.length()-lcs;
        int deletion2=s2.length()-lcs;
        return deletion1+deletion2;
    }
}