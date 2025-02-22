class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        findcomb(candidates,target,res,0,new ArrayList<>());
        return res;
    }
    private void findcomb(int[] arr,int target,List<List<Integer>>res,int start,List<Integer>comb){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int i=start;i<arr.length;i++){
            if(i>start && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>target){
                break;
            }
            comb.add(arr[i]);
            findcomb(arr,target-arr[i],res,i+1,comb);
            comb.remove(comb.size()-1);
        }
    }
}