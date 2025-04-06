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
        if(root==null) return new ArrayList<>();
        List<List<Integer>>ans=new ArrayList<>();
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        boolean flag=false;//0-> L -> R and 1-> R-> L
        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> level=new ArrayList<>();
            for(int i=1;i<=size;i++){
                TreeNode curr=que.remove();
                level.add(curr.val);
                if(curr.left!=null){
                    que.add(curr.left);
                }
                if(curr.right!=null){
                    que.add(curr.right);
                }
            }
            if(flag){
                Collections.reverse(level);

            }
            ans.add(level);
            flag=!flag;
        }
        return ans;
    }
}