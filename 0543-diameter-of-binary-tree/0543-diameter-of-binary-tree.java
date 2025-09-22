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
    public int findDiameter (TreeNode root,int ans[]){
        if(root==null) return 0;

        int leftH=findDiameter(root.left,ans);
        int rightH=findDiameter(root.right,ans);

        ans[0]=Math.max(ans[0],leftH+rightH);

        return Math.max(leftH,rightH)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int ans[]=new int[1];
        findDiameter(root,ans);
        return ans[0];
    }
}