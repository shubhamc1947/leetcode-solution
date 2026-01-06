class Solution {
    public void helper(int arr[],int idx,int n,int tar,List<Integer> curr,List<List<Integer>> res){
        if(tar==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(idx==n || tar<0){
            return;
        }
        //take 
        tar=tar-arr[idx];
        curr.add(arr[idx]);
        helper(arr,idx,n,tar,curr,res);
        tar=tar+arr[idx];
        curr.remove(curr.size()-1);

        helper(arr,idx+1,n,tar,curr,res);
    }
    public List<List<Integer>> combinationSum(int[] arr, int tar) {
        List<List<Integer>> res= new ArrayList<>();
        helper(arr,0,arr.length,tar,new ArrayList<>(),res);
        return res;
    }
}
