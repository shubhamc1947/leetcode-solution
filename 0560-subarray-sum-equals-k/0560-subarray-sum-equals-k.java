class Solution {
    public int subarraySum(int[] arr, int k) {
        int n=arr.length;
        int freq=0;
        for(int i=0;i<n;i++){
            int currSum=0;
            for(int j=i;j<n;j++){
                currSum+=arr[j];

                if(currSum==k){
                    freq++;
                }
            }
        }
        return freq;
        
    }
}