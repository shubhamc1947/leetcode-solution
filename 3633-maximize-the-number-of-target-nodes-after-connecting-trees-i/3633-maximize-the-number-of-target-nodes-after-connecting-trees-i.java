class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1, m = edges2.length + 1;
        int[] ans = new int[n];
        
        Map<Integer, List<Integer>> adj1 = new HashMap<>(), adj2 = new HashMap<>();
        for (int[] edge : edges1) {
            adj1.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            adj1.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }
        for (int[] edge : edges2) {
            adj2.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            adj2.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(dfs(adj2, i, k - 1, new HashSet<>()), max);
        }

        for (int i = 0; i < n; i++) {
            ans[i] = dfs(adj1, i, k, new HashSet<>()) + max;
        }
        return ans;
    }
    private int dfs(Map<Integer, List<Integer>> adj, int node, int k, Set<Integer> visited) {
        if (k < 0) return 0;
        visited.add(node);
        int count = 1;
        for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) count += dfs(adj, neighbor, k - 1, visited);
        }
        return count;
    }
    
}