class Solution {
    public int longestOnes(int[] arr, int k) {
        int si=0;
        int ei=0;
        int ansLen=0;
        int n=arr.length;
        int countZero=0;
        while(ei<n){
            if(arr[ei]==0){
                countZero++;
            }

            while(countZero>k){
                if(arr[si]==0){
                    countZero--;
                }
                si++;
            }

            ansLen=Math.max(ansLen,ei-si+1);
            ei++;
        }
        return ansLen;
    }
}