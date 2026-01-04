class Solution {
    public void helper(int idx,int n,int currSum,int tar, int arr[],ArrayList<Integer> curr,List<List<Integer>> res){
        if(currSum==tar){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(currSum>tar || idx==n) return;
        //take
        curr.add(arr[idx]);
        currSum+=arr[idx];
        helper(idx,n,currSum,tar,arr,curr,res);
        currSum-=arr[idx];
        curr.remove(curr.size()-1);

        //not take
        helper(idx+1,n,currSum,tar,arr,curr,res);
    }
    public List<List<Integer>> combinationSum(int[] arr, int tar) {
        List<List<Integer>> res=new ArrayList<>();
        int idx=0;
        int n=arr.length;
        helper(idx,n,0,tar,arr,new ArrayList<>(),res);
        return res;
    }
}