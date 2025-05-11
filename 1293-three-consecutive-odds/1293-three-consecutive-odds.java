class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n=arr.length;
        int freqCount=0;
        for(int i=0;i<n;i++){
            if(arr[i]%2!=0){// if 
                freqCount++;
                if(freqCount==3){
                    return true;
                }
            }else {
                freqCount=0;
            }
        }
        return false;
    }
}