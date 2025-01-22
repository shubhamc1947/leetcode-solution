class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
                ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<pre.length;i++){
            adj.get(pre[i][0]).add(pre[i][1]);
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
        Stack<Integer> st=new Stack<>();
        while(!que.isEmpty()){
            int node=que.remove();
            st.push(node);
            for(int i=0;i<adj.get(node).size();i++){
                int ele=adj.get(node).get(i);
                inOrder[ele]--;
                if(inOrder[ele]==0){
                    que.add(ele);
                }
            }
        }
        if(st.size()!=numCourses){
            return new int[]{};
        }
        int ans[]=new int[numCourses];
        int idx=0;
        while(!st.isEmpty()){
            ans[idx++]=st.pop();
        }
        return ans;
    }
}