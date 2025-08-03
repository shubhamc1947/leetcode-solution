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
    public int maxPathSumFunc(TreeNode root,int ans[]){
        if(root==null) return 0;
        int leftMaxPathSum=maxPathSumFunc(root.left,ans);
        int rightMaxPathSum=maxPathSumFunc(root.right,ans);

        if(leftMaxPathSum<0){
            leftMaxPathSum=0;
        }
        if(rightMaxPathSum<0){
            rightMaxPathSum=0;
        }
        ans[0]=Math.max(leftMaxPathSum+rightMaxPathSum+root.val,ans[0]);

        return Math.max(leftMaxPathSum,rightMaxPathSum)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        int ans[]=new int[1];
        ans[0]=Integer.MIN_VALUE;
        maxPathSumFunc(root,ans);
        return ans[0];
    }
}