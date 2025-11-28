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
    public void helper(List<String> ans, TreeNode root, String currPath){
        if(root==null) return;
        if(root.left==null && root.right==null){
            //leaf node
            currPath+=root.val+"";
            ans.add(currPath);
            return;
        }

        helper(ans,root.left,currPath+root.val+"->");
        helper(ans,root.right, currPath+root.val+"->");
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        helper(ans,root,"");
        return ans;
    }
}