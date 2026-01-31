class Solution {
    public char nextGreatestLetter(char[] arr, char tar) {
        char ans=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>tar){
                ans=arr[i];
                break;
            }
        }
        return ans;
    }
}