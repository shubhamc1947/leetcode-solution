class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] has_box = new boolean[n], has_key = new boolean[n], opened = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        for(int b: initialBoxes){
            has_box[b] = true;
            if(status[b] == 1) queue.offer(b);
        }
        int total = 0;
        while(!queue.isEmpty()){
            int box = queue.poll();
            if(opened[box]) continue;
            opened[box] = true;
            total += candies[box];
            for(int k: keys[box]){
                if(!has_key[k]){
                    has_key[k] = true;
                    if(has_box[k] && !opened[k]) queue.offer(k);
                }
            }
            for(int inner: containedBoxes[box]){
                if(!has_box[inner]){
                    has_box[inner] = true;
                    if((status[inner] == 1 || has_key[inner]) && !opened[inner]) queue.offer(inner);
                }
            }
        }
        return total;
    }
}