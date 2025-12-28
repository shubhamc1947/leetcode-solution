class Solution {
    public void helper(int nums[],int curr,int n,List<Integer> currL,List<List<Integer>> ans){
        if(curr>n) return;
        if(curr==n){
            ans.add(new ArrayList<>(currL));
            return;
        }

        helper(nums,curr+1,n,currL,ans);
        
        currL.add(nums[curr]);
        helper(nums,curr+1,n,currL,ans);
        currL.remove(currL.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums,0,nums.length,new ArrayList<>(),ans);
        return ans;
    }
}