class Solution {
    public void helper(int arr[],int marker[],int n,List<Integer> curr, List<List<Integer>> res){
        if(curr.size()==n){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size()>n) return;
        for(int i=0;i<n;i++){
            if(marker[i]==0){
                marker[i]=1;
                curr.add(arr[i]);
                helper(arr,marker,n,curr,res);
                marker[i]=0;
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> res=new ArrayList<>();
        
        helper(arr,new int[arr.length],arr.length,new ArrayList<>(),res);
        return res;
    }
}