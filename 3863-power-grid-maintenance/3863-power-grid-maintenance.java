import java.util.*;

class Solution {
    int[] parent;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c + 1];
        for (int i = 1; i <= c; i++) parent[i] = i;

        // Union all connected components
        for (int[] conn : connections) {
            union(conn[0], conn[1]);
        }

        // Build TreeSet of online nodes for each component
        Map<Integer, TreeSet<Integer>> gridMap = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = find(i);
            gridMap.putIfAbsent(root, new TreeSet<>());
            gridMap.get(root).add(i);
        }

        List<Integer> ans = new ArrayList<>();
        Set<Integer> offline = new HashSet<>();

        for (int[] query : queries) {
            int type = query[0], x = query[1];

            if (type == 1) {
                if (!offline.contains(x)) {
                    ans.add(x); // online → self
                } else {
                    int root = find(x);
                    TreeSet<Integer> grid = gridMap.get(root);
                    if (grid == null || grid.isEmpty()) {
                        ans.add(-1);
                    } else {
                        ans.add(grid.first()); // smallest online in same grid
                    }
                }
            } else {
                // Go offline
                offline.add(x);
                int root = find(x);
                TreeSet<Integer> grid = gridMap.get(root);
                if (grid != null) {
                    grid.remove(x);
                }
            }
        }

        // Convert list to array
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) result[i] = ans.get(i);
        return result;
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int a, int b) {
        parent[find(a)] = find(b);
    }
}
