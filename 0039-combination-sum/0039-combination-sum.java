class Solution {
    public void helper(int arr[],int idx,int n,int tar,List<Integer> curr,List<List<Integer>> res){
        if(tar==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(idx==n || tar<0){
            return;
        }
        for(int i=idx;i<n;i++){
            curr.add(arr[i]);
            tar=tar-arr[i];
            helper(arr,i,n,tar,curr,res);
            tar=tar+arr[i];
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] arr, int tar) {
        List<List<Integer>> res= new ArrayList<>();
        helper(arr,0,arr.length,tar,new ArrayList<>(),res);
        return res;
    }
}
