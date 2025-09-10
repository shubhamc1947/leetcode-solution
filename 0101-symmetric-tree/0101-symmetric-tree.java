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
    private boolean isSymmetricHelper(TreeNode l, TreeNode r){
        if(l==null || r==null) {
            return l==r;
        }
        if(l.val!=r.val) return false;

        return isSymmetricHelper(l.left,r.right) && isSymmetricHelper(l.right,r.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return (root==null || isSymmetricHelper(root.left,root.right));
    }
}