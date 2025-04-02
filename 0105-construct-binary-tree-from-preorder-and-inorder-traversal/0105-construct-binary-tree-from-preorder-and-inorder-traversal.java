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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder , inorder , 0 , inorder.length-1);
    }
    int preidx=0;
    public TreeNode solve(int[] pre , int[] in, int si, int ei){
        if(si>ei) return null;
        //find idx of preorder element in inOrder
        int inOrderIdx=index(in , si , ei , pre[preidx]);

        //Root mil gya
        TreeNode root=new TreeNode(pre[preidx++]);

        //left root
        root.left=solve(pre,in , si,inOrderIdx-1);
        root.right=solve(pre,in ,inOrderIdx+1,ei);
        return root;
    }

    public int index(int[] in , int si,int ei, int tar){
        for(int i=si;i<=ei;i++){
            if(in[i]==tar){
                return i;
            }
        }
        return -1;
    }
}