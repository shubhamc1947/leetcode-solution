class Solution {
   
    public int cherryPickup(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int prev[][]=new int[m][m];

        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2) prev[j1][j2]=arr[n-1][j2];
                else prev[j1][j2]=arr[n-1][j1]+arr[n-1][j2];
            }
        }

        for(int i=n-2;i>=0;i--){
            int curr[][]=new int[m][m];
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxi=-(int)1e8;
                    
                    for(int d1=-1;d1<=1;d1++){
                        for(int d2=-1;d2<=1;d2++){
                            int currVal=-(int)1e8;
                            if(j1+d1>=0 && j1+d1<m && j2+d2>=0 && j2+d2<m){
                                currVal=prev[j1+d1][j2+d2];

                            }
                            if(j1==j2){
                                currVal+=arr[i][j1];
                            }else{
                                currVal+=arr[i][j1]+arr[i][j2];
                            }
                            maxi=Math.max(maxi,currVal);
                        }
                    }
                    curr[j1][j2] = maxi;
                }
            }
            prev=curr;
        }

        return prev[0][m-1];
    }
}