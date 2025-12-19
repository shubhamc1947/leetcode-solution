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
    public TreeNode buildBST(int si,int ei,int nums[]){
        if(si<=ei){
            int mid=(si+ei)/2;
            TreeNode root=new TreeNode(nums[mid]);
            root.left=buildBST(si,mid-1,nums);
            root.right=buildBST(mid+1,ei,nums);
            return root;
        }else{
            return null;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(0,nums.length-1,nums);
    }
}