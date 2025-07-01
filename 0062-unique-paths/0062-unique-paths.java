class Solution {
    
    public int uniquePaths(int m, int n) {
        int prev[]=new int[n];
        for(int i=0;i<m;i++){
            int curr[]=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    curr[0]=1;
                }else{
                    int top=0;
                    int left=0;
                    if(i-1>=0){
                        top=prev[j];
                    }
                    if(j-1>=0) {
                        left=curr[j-1];
                    }
                    curr[j]= top+left;
                }
            }
            prev=curr;
        }

        return prev[n-1];
    }
}