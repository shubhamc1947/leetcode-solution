class Solution {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (indexMap.containsKey(num)) {
                for (int j : indexMap.get(num)) {
                    if ((i * j) % k == 0) {
                        count++;
                    }
                }
            }
            indexMap.computeIfAbsent(num, x -> new ArrayList<>()).add(i);
        }

        return count;
    }
}