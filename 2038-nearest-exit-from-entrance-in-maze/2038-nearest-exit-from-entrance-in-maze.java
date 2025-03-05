// Easy peasy lemon squeazyyy

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int level = 0;
        visited[entrance[0]][entrance[1]] = true;
        int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        q.offer(entrance);
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            while(size > 0){
                int[] coordinates = q.poll();
                //Going in 4 directions (up, down, right, left)
                for(int i = 0; i < 4; i++){
                    int[] dir = dirs[i];
                    int nextR = coordinates[0] + dir[0];
                    int nextC = coordinates[1] + dir[1];
                    //checking limits
                    if(nextR >= 0 && nextC >= 0 && nextR < maze.length && nextC < maze[0].length && 
                    maze[nextR][nextC] == '.' && !visited[nextR][nextC]){
                        //checking boundaries
                        if(nextR == 0 || nextC == 0 || nextR == maze.length-1 || nextC == maze[0].length-1){
                            return level;
                        }
                        visited[nextR][nextC] = true;
                        q.add(new int[] {nextR, nextC});
                    }
                }
                size--;
            }
        }
        return -1;
    }
}