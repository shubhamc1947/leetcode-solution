class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean arr[] = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        arr[0] = true;
        queue.offer(0);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int key: rooms.get(curr)){
                if(!arr[key]){
                    arr[key] = true;
                    queue.add(key);
                }   
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(!arr[i]){
                return false;
            }
        }
       
        return true;
    }
}