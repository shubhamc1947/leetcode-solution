import java.util.*;

class Solution {
    public long minimumDifference(int[] nums) {
        int n3 = nums.length;
        int n = n3 / 3;

        long[] leftMin = new long[n3];
        long[] rightMin = new long[n3];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long leftSum = 0;
        for (int i = 0; i < n3; ++i) {
            maxHeap.offer(nums[i]);
            leftSum += nums[i];
            if (maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }
            if (i >= n - 1) {
                leftMin[i] = leftSum;
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightSum = 0;
        for (int i = n3 - 1; i >= 0; --i) {
            minHeap.offer(nums[i]);
            rightSum += nums[i];
            if (minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }
            if (i <= n3 - n) {
                rightMin[i] = rightSum;
            }
        }

        long result = Long.MAX_VALUE;
        for (int i = n - 1; i <= n3 - n - 1; ++i) {
            result = Math.min(result, leftMin[i] - rightMin[i + 1]);
        }

        return result;
    }
}