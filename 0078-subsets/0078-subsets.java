class Solution {
    public void helper(int arr[],int idx, int n, ArrayList<Integer> curr, List<List<Integer>> res){
        if(idx==n){
            res.add(new ArrayList<>(curr));
            return;
        }
        //take
        curr.add(arr[idx]);
        helper(arr,idx+1,n,curr,res);
        curr.remove(curr.size()-1);

        //nottake
        helper(arr,idx+1,n,curr,res);
    }
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> res=new ArrayList<>();
        helper(arr,0,arr.length,new ArrayList<Integer>(),res);
        return res;
    }
}