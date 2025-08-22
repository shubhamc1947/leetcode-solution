class Solution {
    public int minimumArea(int[][] arr) {
        int xLeftMin=Integer.MAX_VALUE,xRightMax=Integer.MIN_VALUE,yUpMin=Integer.MAX_VALUE,yDownMax=Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[0].length; j++) {
                        if(arr[i][j]==1){

                            xLeftMin=Math.min(xLeftMin, j);
                            xRightMax=Math.max(xRightMax,j);
                            yUpMin=Math.min(yUpMin,i);
                            yDownMax=Math.max(yDownMax,i);
                        }
                    }
                }
                // System.out.println(xLeftMin+" "+xRightMax+" "+yUpMin+" "+ yDownMax);
                int ans=(xRightMax-xLeftMin+1)*(yDownMax-yUpMin+1);
        return ans;

    }
}