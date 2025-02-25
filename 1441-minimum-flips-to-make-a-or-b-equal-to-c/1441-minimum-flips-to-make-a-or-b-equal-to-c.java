class Solution {
    public int minFlips(int a, int b, int c) {
        int flips=0;
        while (a>0||b>0||c>0){
            int bitsA=a&1;
            int bitsB=b&1;
            int bitsC=c&1;
            if((bitsA|bitsB)!=bitsC){
                if(bitsC==0){
                    flips+=bitsA + bitsB; 
                }else{
                    flips+=1;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flips;
    }
}