class Solution {
    private static final int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            pq.offer(new int[] {heightMap[i][0] , i , 0});
            pq.offer(new int[] {heightMap[i][n - 1] , i , n - 1});
            vis[i][0] = true;
            vis[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pq.offer(new int[] {heightMap[0][j] , 0 , j});
            pq.offer(new int[] {heightMap[m - 1][j] , m - 1 , j});
            vis[0][j] = true;
            vis[m - 1][j] = true;
        }

        int totalWater = 0;

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int height = cell[0];
            int x = cell[1];
            int y = cell[2];

            for (int[] dir : dirs) {
                int dx = x + dir[0];
                int dy = y + dir[1];

                if (dx >= 0 && dx < m && dy >= 0 && dy < n && !vis[dx][dy]) {
                    vis[dx][dy] = true;
                    totalWater += Math.max(0 , height - heightMap[dx][dy]);
                    pq.offer(new int[] {Math.max(height , heightMap[dx][dy]) , dx , dy});
                }
            }
        }
        return totalWater;
    }
}