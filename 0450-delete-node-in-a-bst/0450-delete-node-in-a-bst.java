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
    public TreeNode findMax(TreeNode root){
        if(root==null) return null;
        if(root.right==null){
            return root;
        }else{
            return findMax(root.right);
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val>key){
            root.left= deleteNode(root.left,key);
        }else if(root.val<key){
            root.right= deleteNode(root.right,key);
        }else {
            //find what kind of node it this
            if(root.left==null && root.right==null){
                return null;
            }else if(root.left==null){
                root=root.right;
            }else if(root.right==null){
                root=root.left;
            }else{
                TreeNode maxi=findMax(root.left);
                root.val=maxi.val;
                root.left = deleteNode(root.left,maxi.val);
            }
        }
        return root;
    }
}