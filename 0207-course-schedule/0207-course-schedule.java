class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<pre.length;i++){
            int a = pre[i][0];
            int b = pre[i][1];
            adj.get(b).add(a);   // b -> a (CORRECT)
        }
        // System.out.println(adj);
        // return true;

        //inOrder Array 
        int inOrder[]=new int[adj.size()];
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                int ele=adj.get(i).get(j);
                inOrder[ele]++;
            }
        }

        // queue making for putting 0 inorder ele
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<inOrder.length;i++){
            if(inOrder[i]==0){
                que.add(i);
            }
        }

        // ans
        ArrayList<Integer> ans=new ArrayList<>();
        while(!que.isEmpty()){
            int node=que.remove();
            ans.add(node);
            for(int i=0;i<adj.get(node).size();i++){
                int ele=adj.get(node).get(i);
                inOrder[ele]--;
                if(inOrder[ele]==0){
                    que.add(ele);
                }
            }
        }
        return ans.size()==adj.size()?true:false;

    }
}