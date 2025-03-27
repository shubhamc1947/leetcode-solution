import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        
        for (int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }

       
        int max = -1;
        for (int key : map.keySet()) {
            if (map.get(key) * 2 > nums.size()) { 
                max = key;
                break;
            }
        }

        if (max == -1) return -1;

        
        int cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == max) {
                cnt++;
                int leftSize = i + 1;
                int rightSize = nums.size() - leftSize;
                int rightCount = map.get(max) - cnt; 

                if (cnt * 2 > leftSize && rightCount * 2 > rightSize) {
                    return i;
                }
            }
        }
        return -1;
    }
}