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
    public void solve(TreeNode root, List<Integer> preOrderList){
        if(root==null){
            return;
        }
        preOrderList.add(root.val);
        solve(root.left,preOrderList);
        solve(root.right,preOrderList);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderList=new ArrayList<>();
        if(root==null) return preOrderList;
        solve(root,preOrderList);
        return preOrderList;
    }
}