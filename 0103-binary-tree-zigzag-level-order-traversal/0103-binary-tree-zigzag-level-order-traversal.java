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
        que.add(root);
        boolean leftToRigth=true;
        while(!que.isEmpty()){

            int size=que.size();
            Deque<Integer> currList=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=que.remove();

                if(leftToRigth==true){
                    currList.addLast(curr.val);
                }else{
                    currList.addFirst(curr.val);
                }

                if(curr.left!=null) que.add(curr.left);
                if(curr.right!=null) que.add(curr.right);
            }
            leftToRigth=!leftToRigth;
            ans.add(new ArrayList<>(currList));
        }


        return ans;
    }
}