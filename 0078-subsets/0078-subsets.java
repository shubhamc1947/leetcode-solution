class Solution {
    public void helper(int arr[],int idx,int n,List<List<Integer>> res,  List<Integer> curr){
        if(idx>n || idx<0) return;
        if(idx==n){
            res.add(new ArrayList<>(curr));
            return;
        }
        //take 
        curr.add(arr[idx]);
        helper(arr,idx+1,n,res,curr);
        curr.remove(curr.size()-1);

        //not take
        helper(arr,idx+1,n,res,curr);
    }
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> res=new ArrayList<>();
        helper(arr,0,arr.length,res,new ArrayList<>());
        return res;
    }
}