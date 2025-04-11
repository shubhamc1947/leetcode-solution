class Solution {
    
    public static int SumDigit(int num){
        int sum=0;
        while(num!=0){
            int lastDigit=num%10;
            sum+=lastDigit;
            num/=10;
        }
        return sum;
    }
    public static boolean isSymmertric(int num){

        int digitCount=(int)Math.log10(num)+1;
        int right=num% (int)Math.pow(10,digitCount/2);
        int left=num / (int)Math.pow(10,digitCount/2);

        if(SumDigit(left)==SumDigit(right)){
            return true;
        }
        return false;

    }
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++){
            int digitCount=(int)Math.log10(i)+1;
            if(digitCount%2==0 && isSymmertric(i)){
                count++;
            }
        }
        return count;
    }
}