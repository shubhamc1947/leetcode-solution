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
    public boolean isValidBSTFunc(TreeNode root,long mini,long maxi){
        if(root==null) return true;
        if(root.val>mini && root.val<maxi){
            return isValidBSTFunc(root.left,mini,root.val) && isValidBSTFunc(root.right,root.val,maxi);
        }else{
            return false;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTFunc(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}