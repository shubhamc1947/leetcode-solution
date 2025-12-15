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
    public void solve(TreeNode root,List<Integer> ans,int curr){
        if(root==null) return;
        curr=curr*10+root.val;
        if(root.left==null && root.right==null){
            ans.add(curr);
            return;
        }
        solve(root.left,ans,curr);
        solve(root.right,ans,curr);
        curr=curr/10;
    }
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        List<Integer> ans=new ArrayList<>();
        solve(root,ans,0);
        int ansvar=0;
        for(int curr:ans){
            ansvar+=curr;
        }
        return ansvar;
    }
}