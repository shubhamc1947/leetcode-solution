class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int n=arr.length;
        int maxFreq=0,currFreq=0;
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                currFreq++;
                maxFreq=Math.max(currFreq,maxFreq);
            }else{
                currFreq=0;
            }
        }
        return maxFreq;
    }
}