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
    public int maxi(TreeNode root,int ans[]){
        if(root==null) return 0;
        int lSum=maxi(root.left,ans);
        if(lSum<0) lSum=0;

        int rSum=maxi(root.right,ans);// incase of lower 

        if(rSum<0) rSum=0;
        ans[0]=Math.max(ans[0],lSum+rSum+root.val);
        
        return Math.max(lSum,rSum)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        if(root.left==null && root.right==null) return root.val;
        int ans[]=new int[1];
        ans[0]=Integer.MIN_VALUE;
        maxi(root,ans);
        return ans[0];
    }
}