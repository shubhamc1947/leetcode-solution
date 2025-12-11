class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, List<Integer>> row = new HashMap<>();
        Map<Integer, List<Integer>> col = new HashMap<>();

        // Group by row & column
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            row.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            col.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        // Sort each list
        for (List<Integer> r : row.values()) Collections.sort(r);
        for (List<Integer> c : col.values()) Collections.sort(c);

        int covered = 0;

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            List<Integer> r = row.get(x);
            List<Integer> c = col.get(y);

            int idxR = Collections.binarySearch(r, y);
            int idxC = Collections.binarySearch(c, x);

            boolean horizontal = idxR > 0 && idxR < r.size() - 1;
            boolean vertical   = idxC > 0 && idxC < c.size() - 1;

            if (horizontal && vertical)
                covered++;
        }

        return covered;
    }
}