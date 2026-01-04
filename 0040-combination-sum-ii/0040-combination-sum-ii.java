class Solution {
    public void helper(int arr[],int tar,int idx,int n,int currSum,ArrayList<Integer> curr,List<List<Integer>> res){
        if(currSum==tar){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(currSum>tar || idx==n) return;
        
        for(int i=idx;i<n;i++){
            if(i>idx && arr[i]==arr[i-1]) continue;
            curr.add(arr[i]);
            currSum+=arr[i];
            helper(arr,tar,i+1,n,currSum,curr,res);
            curr.remove(curr.size()-1);
            currSum-=arr[i];
        }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int tar) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(arr);

        helper(arr,tar,0,arr.length,0,new ArrayList<>(),res);
        return res;

    }
}