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
    public void solve(TreeNode root, List<Integer> inOrderList){
        if(root==null) return;
        solve(root.left,inOrderList);
        inOrderList.add(root.val);
        solve(root.right,inOrderList);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrderList=new ArrayList<>();
        if(root==null) return 0;
        solve(root,inOrderList);
        return inOrderList.get(k-1);
    }
}