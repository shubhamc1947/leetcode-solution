class Solution {
    public int uniquePaths(int n, int m) {
        int prev[]=new int[m];
   
        for(int i=0;i<n;i++){
            int temp[]=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    temp[j]=1;
                }else{
                    int top=0;
                    int left=0;
                    if(i-1>=0) top=prev[j];
                    if(j-1>=0) left=temp[j-1];
                    temp[j]=top+left;
                }
            }
            prev=temp;
        }
        return prev[m-1];
    }
}