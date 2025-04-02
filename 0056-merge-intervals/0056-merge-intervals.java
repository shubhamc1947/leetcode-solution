import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        List<int[]> res = new ArrayList<>();
        
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] curVal = intervals[0];
        
        // Step 2: Iterate and merge overlapping intervals
        for (int i = 1; i < len; i++) {
            if (curVal[1] >= intervals[i][0]) {
                curVal[1] = Math.max(curVal[1], intervals[i][1]);
            } else {
                res.add(curVal);
                curVal = intervals[i];
            }
        }
        res.add(curVal);
        
        // Step 3: Convert list to array
        return res.toArray(new int[res.size()][]);
    }
}