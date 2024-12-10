class Solution {
    public List<List<Integer>> generate(int arr) {
        List<List<Integer>> ans=new ArrayList<>();
        if(arr<=0) return ans;
        ans.add(Arrays.asList(1));
        for(int i=1;i<arr;i++){
            List<Integer> curr=new ArrayList<>();
            List<Integer> prev=ans.get(i-1);
            curr.add(1);
            for(int j=1;j<i;j++){
                curr.add(prev.get(j)+prev.get(j-1));
            }
            curr.add(1);

            ans.add(new ArrayList<>(curr));
        }
        return ans;
    }
}