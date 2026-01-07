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
    int MOD=1000000007;
    private long totSum(TreeNode root){
        if(root==null) return 0;
        return root.val+totSum(root.left)+totSum(root.right);
    }
    private long helper(TreeNode root, long ans[],long totalSum){
        if(root==null) return 0;
        long leftSum=helper(root.left,ans,totalSum);
        long rightSum=helper(root.right,ans,totalSum);
        long currSum=leftSum+rightSum+root.val;
        ans[0]=Math.max(ans[0],currSum*(totalSum-currSum));
        return currSum;
    }
    public int maxProduct(TreeNode root) {
        long totalSum=totSum(root);
        System.out.println(totalSum);
        // product subTreeSum* (totalSum-subTreeSum)
        //FIND THE MAXIMUM
        long ans[]=new long[1];
        helper(root,ans,totalSum);
        return (int)(ans[0]%MOD);
    }
}