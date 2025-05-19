class Solution {
    public String triangleType(int[] arr) {
        int a=arr[0];
        int b=arr[1];
        int c=arr[2];
        if(a+b>c && b+c>a && c+a>b){
            if(a==b && b==c && c==a){
                return "equilateral";
            }else if((a==b)|| (b==c)||(c==a)){
                return "isosceles";
            }else {
                return "scalene";
            }
        }else{
            return "none";
        }
        
    }
}