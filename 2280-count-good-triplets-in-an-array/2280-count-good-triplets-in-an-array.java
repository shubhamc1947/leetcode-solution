class Solution {

    public long goodTriplets(int[] nums1, int[] nums2) {
        Map<Integer, Integer> elemToIndexMappingInB = new HashMap<>();
        int n = nums1.length;
        long[] segmentTree = new long[n * 4 + 1];
        long ans = 0;
        for (int i = 0; i < nums2.length; i++) {
            elemToIndexMappingInB.put(nums2[i], i);
        }
        update(segmentTree, 1, 0, n - 1, elemToIndexMappingInB.get(nums1[0]));
        for (int i = 1; i < n; i++) {
            int indexInB = elemToIndexMappingInB.get(nums1[i]);
            long commonElementsOnLeft = query(segmentTree, 1, 0, n - 1, 0, indexInB);
            long uniqueElementsOnLeftInA = i - commonElementsOnLeft;
            long elementsAfterIndexInB = n - 1 - indexInB;
            long commonElementsOnRight = elementsAfterIndexInB - uniqueElementsOnLeftInA;
            ans += commonElementsOnLeft * commonElementsOnRight;
            update(segmentTree, 1, 0, n - 1, indexInB);
        }
        return ans;
    }

    private void update(long[] st, int index, int start, int end, int updateIndex) {
        if (start == end) {
            st[index] += 1;
            return;
        }
        int mid = start + (end - start) / 2;
        if (updateIndex <= mid) update(st, index * 2, start, mid, updateIndex);
        else update(st, index * 2 + 1, mid + 1, end, updateIndex);
        st[index] = st[index * 2] + st[index * 2 + 1];
    }

    private long query(long[] st, int index, int start, int end, int queryStart, int queryEnd) {
        if (end < queryStart || start > queryEnd) return 0;
        if (start >= queryStart && end <= queryEnd) return st[index];
        int mid = start + (end - start) / 2;
        long left = query(st, index * 2, start, mid, queryStart, queryEnd);
        long right = query(st, index * 2 + 1, mid + 1, end, queryStart, queryEnd);
        return left + right;
    }
}