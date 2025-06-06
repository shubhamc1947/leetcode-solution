class Solution {
    
    public int minDistance(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int prev[]=new int[m+1];
        
        for(int j=0;j<=m;j++){
            prev[j]=j;
        }

        for(int i=1;i<=n;i++){
            int curr[]=new int[m+1];
            curr[0]=i;
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    //match
                    curr[j]= 0 + prev[j-1];
                }else{
                    // insert
                    int insert=1+curr[j-1];
                    //delete
                    int delete=1+prev[j];
                    //replace
                    int replace=1+prev[j-1];
                    curr[j]= Math.min(insert,Math.min(delete,replace));
                }
            }
            prev=curr;
        }

        return prev[m];
    }
}