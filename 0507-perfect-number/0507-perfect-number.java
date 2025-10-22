class Solution {
    public boolean checkPerfectNumber(int num) {
        int searchSpace=(int)num/2;
        int factorSum=0;
        for(int i=1;i<=searchSpace;i++){
            if(num%i==0){
                factorSum+=i;
            }
        }
        return factorSum==num;
    }
}