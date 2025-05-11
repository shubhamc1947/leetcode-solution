class Solution {
    public int majorityElement(int[] arr) {
        int curr=arr[0];
        int freq=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==curr){
                freq++;
            }else{
                freq--;
                if(freq==0){
                    curr=arr[i];
                    freq=1;
                }
            }
        }
        return curr;
    }
}