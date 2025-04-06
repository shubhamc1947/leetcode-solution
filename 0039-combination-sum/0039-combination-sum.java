class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        process(candidates,target,list,0,new ArrayList<>());
        return list;
    }
    static void process(int[] candidates, int target,List<List<Integer>> list,int start,ArrayList<Integer> arr){
        if(target == 0){
            list.add(new ArrayList<>(arr));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i=start;i<candidates.length;i++){
            arr.add(candidates[i]);
            process(candidates,target - candidates[i],list,i,arr);
            arr.removeLast();
        }
    }
}