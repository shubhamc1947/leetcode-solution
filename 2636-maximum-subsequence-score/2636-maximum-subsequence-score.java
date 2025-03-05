class Solution {
    static final int SHIFT = 20;
    static final long MASK = 0xF_FFFFL;
    
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
   
        long[] nums21 = new long[n];
        for (int i = n - 1; i >= 0; i--) 
            nums21[i] = ((long)nums2[i] << SHIFT) | nums1[i];
        Arrays.sort(nums21);
        
      
        PriorityQueue<Integer> kNumFromNums1 = new PriorityQueue(k + 1);
        long sumFromNums1 = 0;
        int idx21 = n - k;
        for (int i = idx21; i < n; i++) {
            sumFromNums1 += (nums21[i] & MASK);
            kNumFromNums1.add((int)(nums21[i] & MASK));
        }

        
        long result = sumFromNums1 * (nums21[idx21] >> SHIFT);
        while (--idx21 >= 0) {
            sumFromNums1 += (nums21[idx21] & MASK) - kNumFromNums1.poll();
            kNumFromNums1.add((int)(nums21[idx21] & MASK));
            result = Math.max(result, sumFromNums1 * (nums21[idx21] >> SHIFT));
        }
        return result;
    }
}