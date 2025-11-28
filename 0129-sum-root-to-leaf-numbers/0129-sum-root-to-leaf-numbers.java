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
    public void helper(TreeNode root,int curr, ArrayList<Integer> arr){
        if(root==null) return ;
        curr=curr*10+root.val;
        if(root.left==null && root.right==null){
            arr.add(curr);
            return ;
        }
        helper(root.left,curr,arr);
        helper(root.right,curr,arr);
    }
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        ArrayList<Integer> arr=new ArrayList<>();
        helper(root,0,arr);
        int cur=0;
        for(int i=0;i<arr.size();i++){
            cur+=arr.get(i);
        }
        return cur;
        
    }
}