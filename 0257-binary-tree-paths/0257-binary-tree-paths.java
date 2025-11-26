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
    public void findAllPath(TreeNode root, List<String> ans,String curr){
        if(root==null){
            return ;
        }
        if(root.left==null && root.right==null){
            ans.add(curr+root.val+"");
            return;
        }
        findAllPath(root.left,ans,curr+root.val+"->");
        findAllPath(root.right,ans,curr+root.val+"->");

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        findAllPath(root,ans,"");
        return ans;
    }
}