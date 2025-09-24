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
    public int helperMaxPathSum(TreeNode root,int ans[]){
        if(root==null) return 0;

        int leftSum=helperMaxPathSum(root.left,ans);
        if(leftSum<0) leftSum=0;
        int rightSum=helperMaxPathSum(root.right,ans);
        if(rightSum<0) rightSum=0;

        ans[0]=Math.max(ans[0],leftSum+rightSum+root.val);
        System.out.println(leftSum+" "+rightSum+" "+ans[0]);
        return Math.max(leftSum,rightSum)+root.val;

    }
    public int maxPathSum(TreeNode root) {
        int ans[]=new int[1];
        ans[0]=Integer.MIN_VALUE;
        helperMaxPathSum(root,ans);
        return ans[0];
    }
}