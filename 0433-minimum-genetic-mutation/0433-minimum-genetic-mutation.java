class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String>visited=new HashSet<>();
        Queue<String>q=new LinkedList<>();
        Set<String>se=new HashSet<>(Arrays.asList(bank));
        visited.add(startGene);
        q.offer(startGene);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String node=q.poll();

                if(node.equals(endGene)) return level;
                for(char st:"ACGT".toCharArray()){
                    for(int k=0;k<node.length();k++){
                        String after=node.substring(0,k)+st+node.substring(k+1);
                        if(!visited.contains(after) && se.contains(after)){
                            visited.add(after);
                            q.offer(after);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
        
    }
}