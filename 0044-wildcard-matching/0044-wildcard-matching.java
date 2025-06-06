class Solution {

    public boolean isMatch(String s2, String s1) {
        //assuming s1 will contains * and ? 
        int n=s1.length();
        int m=s2.length();
        boolean prev[]=new boolean[m+1];
        
        prev[0]=true;
        // for(int j=1;j<=m;j++){ // not needed
        //     prev[j]=false;
        // }

        for(int i=1;i<=n;i++){
            boolean curr[]=new boolean[m+1];
            boolean flag=true;
            for(int x=1;x<=i;x++){
                if(s1.charAt(x-1)!='*'){
                     flag=false;
                     break;
                }
            }
            curr[0]=flag;
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
                    curr[j] = prev[j-1];
                }else{
                    if(s1.charAt(i-1)=='*'){
                        //take * as ""
                        boolean notTake=prev[j];
                        // take * as curr char (but * can be another as well so taking j-1 only)
                        boolean take=curr[j-1];
                        curr[j] = take || notTake?true:false;
                    }else{
                        curr[j] = false;
                    }
                }
            }
            prev=curr;
        }

        return prev[m];
    }
}