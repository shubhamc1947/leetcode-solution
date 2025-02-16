class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        // build a map of node->top k edges
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new PriorityQueue<>());
            map.putIfAbsent(edge[1], new PriorityQueue<>());
            PriorityQueue pq1 = map.get(edge[0]), pq2 = map.get(edge[1]);
            int val1 = vals[edge[1]], val2 = vals[edge[0]];
            if (val1 > 0)
                pq1.add(val1);
            if (pq1.size() > k)
                pq1.poll();
            if (val2 > 0)
                pq2.add(val2);
            if (pq2.size() > k)
                pq2.poll();
        }
        //System.out.println(map);
        int res = -10000;
        for (int i = 0; i < vals.length; i++) {
            int sum = vals[i];
            for (int vEdge : map.getOrDefault(i, new PriorityQueue<>()))
                sum += vEdge;
            //System.out.println(i + "|" + sum + "|" + res);
            res = Math.max(res, sum);
        }
        return res;
    }
}