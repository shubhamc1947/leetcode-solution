class Solution {
    int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public boolean check(int x, int y, int n, int m) {
        return x>=0 && y>=0 && x<n && y<m;
    }
    public void dfs(int i, int j, boolean[][] vis, int[][] heights) {
        vis[i][j] = true;
        for(int ind=0;ind<4;ind++) {
            int x = i + dir[ind][0];
            int y = j + dir[ind][1];
            if(check(x,y,heights.length,heights[0].length) && vis[x][y] == false && heights[x][y] >= heights[i][j]) {
                dfs(x,y,vis,heights);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights.length, m = heights[0].length;
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];
        for(int i=0;i<n;i++) {
            if(pac[i][0] == false) dfs(i, 0, pac, heights);
            if(atl[i][m-1] == false )dfs(i, m-1, atl, heights);
        }
        for(int i=0;i<m;i++) {
            if(pac[0][i] == false) dfs(0, i, pac, heights);
            if(atl[n-1][i] == false )dfs(n-1, i, atl, heights);
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(pac[i][j] && atl[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}