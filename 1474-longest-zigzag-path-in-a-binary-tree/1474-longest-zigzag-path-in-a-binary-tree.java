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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        getZigZagDepth(root);
        return max - 1;
    }

    int[] getZigZagDepth(TreeNode root){
        if(root == null) return new int[]{0,0};
        
        int left = 1;
        int right = 1;
        
        if(root.left != null){
            left += getZigZagDepth(root.left)[1];
        }
        
        if(root.right != null){
            right += getZigZagDepth(root.right)[0];
        }

        max = Math.max(max, Math.max(left, right));
        
        return new int[]{left, right};
    }
}