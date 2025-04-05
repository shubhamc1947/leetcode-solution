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
    static int ans;
    public static void count(TreeNode root,int sum){
        sum=sum*10+root.val;
        if(root.left==null&&root.right==null){
            ans+=sum;
            return;
        }
        if(root.left!=null){
            count(root.left,sum);
        }
        if(root.right!=null){
            count(root.right,sum);
        }
    }
    public int sumNumbers(TreeNode root) {
        ans=0;
        count(root,0);
        return ans;
    }
}