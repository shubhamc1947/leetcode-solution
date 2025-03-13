class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[k];
        int index = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer>[] list = new List[n+1];
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            int freq = e.getValue();
            if(list[freq] == null){
                list[freq] = new ArrayList<>();
            }
            list[freq].add(e.getKey());
        }
        for(int i = list.length-1;i>0 && index<k;i--){
            if(list[i] != null){
                for(int num : list[i]){
                    ans[index++] = num;
                    if(index == k){
                        break;
                    }
                }
            }
        }
        return ans;
    }
}