class Solution {
    
    public int uniquePaths(int m, int n) {
        int prev[]=new int[n];
        
        for(int i=0;i<m;i++){
            int curr[]=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    curr[j]=1;
                }else{
                    int left=0;
                    if(j-1>=0){
                        left=curr[j-1];
                    }
                    int top=0;
                    if(i-1>=0){
                        top=prev[j];
                    }
                    curr[j]= left+top;
                }
            }
            prev=curr;
        }

        return prev[n-1];
    }
}