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
    public void inOrderItr(TreeNode root, ArrayList<Integer> inorderArr){
        if(root==null){
            return;
        }
        inOrderItr(root.left,inorderArr);
        inorderArr.add(root.val);
        inOrderItr(root.right,inorderArr);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> inorderArr=new ArrayList<>();
        inOrderItr(root,inorderArr);
        // System.out.println(inorderArr);
        return inorderArr.get(k-1);
    }
}