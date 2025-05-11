class Solution {
    public int findDuplicate(int[] arr) {
        int n=arr.length;
        HashSet<Integer> hs=new HashSet<>();

        for(int i=0;i<n;i++){
            if(!hs.add(arr[i])){
                return arr[i];
            }
        }
        return -1;
    }
}