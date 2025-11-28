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
class Node{
    int ht;
    int dia;
    public Node(int ht,int dia){
        this.ht=ht;
        this.dia=dia;
    }
}
class Solution {
    public Node helper(TreeNode root){
        if(root==null) return new Node(0,0);

        Node left=helper(root.left);
        Node right=helper(root.right);
        return new Node(Math.max(left.ht,right.ht)+1,Math.max(1+left.ht+right.ht,Math.max(left.dia,right.dia)));

        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Node curr=helper(root);
        return curr.dia-1;
    }
}