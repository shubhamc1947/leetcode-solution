class Solution {
    public static void func(int arr[],int idx,int n,List<Integer> curr,List<List<Integer>> ans){
        if(idx==n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        //notTake
        func(arr,idx+1,n,curr,ans);
        // take
        curr.add(arr[idx]);
        func(arr,idx+1,n,curr,ans);
        curr.remove(curr.size()-1);
    }
    public List<List<Integer>> subsets(int[] arr) {
        int idx=0;
        List<List<Integer>> ans=new ArrayList<>();
        func(arr,0,arr.length,new ArrayList<>(),ans);
        return ans;
    }
}