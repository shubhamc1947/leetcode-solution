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
    public int findHt(TreeNode root,int arr[]){
        if(root==null) return 0;
        int leftH=findHt(root.left,arr);
        int rightH=findHt(root.right,arr);
        arr[0]=Math.max(arr[0],leftH+rightH);
        return Math.max(leftH,rightH)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int arr[]=new int[1];
        int ht=findHt(root,arr);
        return arr[0];
    }
}