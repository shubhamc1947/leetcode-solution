class Solution {
    public int countOperations(int num1, int num2) {
        if(num1==0 || num2==0){
            return 0;
        }
        return 1+countOperations(Math.min(num1,num2),Math.abs(num1-num2));
    }
}