class Solution {
    public void helper(int idx,int tar, int arr[],List<Integer> curr, List<List<Integer>> ans){
        if(tar<0 || idx>=arr.length) return;
        if(tar==0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        //take
        curr.add(arr[idx]);
        tar-=arr[idx];
        helper(idx,tar,arr,curr,ans);
        tar+=arr[idx];
        curr.remove(curr.size()-1);

        //not take
        helper(idx+1,tar,arr,curr,ans);
    }
    public List<List<Integer>> combinationSum(int[] arr, int tar) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,tar,arr,new ArrayList<>(),ans);
        return ans;
    }
}