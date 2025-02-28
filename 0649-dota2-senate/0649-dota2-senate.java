class Solution {
    public String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        Queue<Character> queue = new LinkedList();
        for(char c : chars){
            queue.offer(c);
        }
        int i = 0; 
        int initialQueueSize = queue.size();
        char maj = queue.peek();
        int majCount = 0;
        while(!queue.isEmpty()){
            if(i==initialQueueSize){
                if(queue.size()!=initialQueueSize){
                    initialQueueSize = queue.size();
                    i = 0;
                }else{
                    break;
                }
            }
            if(majCount==0){
                maj=queue.peek();
                majCount++;
                queue.offer(queue.poll());
            }else{
                if(maj!=queue.peek()){
                    queue.poll();
                    majCount--;
                }else{
                    queue.offer(queue.poll());
                    majCount++;
                }
            }
            i++;
        }

        if(queue.peek()=='R'){
            return "Radiant";
        }else{
            return "Dire";
        }
    }
}