class Solution {
    public long totalCost(int[] costs, int k, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> costs[a] == costs[b] ? a - b : costs[a] - costs[b]
        ); 
        long total = 0;
        int n = costs.length, i = 0, j = n-1;

        // c => candidates
        while (i < c) {
            pq.add(i++);
        }
        while (j >= i && j + c >= n) {
            pq.add(j--);
        }

        while (k-->0) {
            int index = pq.poll();
            total += costs[index];
            if (i > j) {
                continue;
            }
            if (index < i) {
                pq.add(i++);
            }
            else {
                pq.add(j--);
            }
        }
        return total;
    }
}