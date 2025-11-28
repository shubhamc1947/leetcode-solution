/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        boolean leftToRight= true;
        while(!que.isEmpty()){
            int size=que.size();
            Deque<Integer> dque=new ArrayDeque<>(size);
            for(int i=0;i<size;i++){
                TreeNode curr=que.poll();
                if(leftToRight){
                    dque.addLast(curr.val);
                }else{
                    dque.addFirst(curr.val);
                }

                if(curr.left!=null) que.offer(curr.left);
                if(curr.right!=null) que.offer(curr.right);

            }
            leftToRight=!leftToRight;
            ans.add(new ArrayList<>(dque));
        }
        return ans;
    }
}