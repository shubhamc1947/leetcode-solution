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
    public void inOrder(TreeNode root,ArrayList<Integer> arr){
        if(root==null) return;
        inOrder(root.left,arr);
        arr.add(root.val);
        inOrder(root.right,arr);
    }
    public boolean checkSortArr(ArrayList<Integer> arr){
        for(int i=1;i<arr.size();i++){
            if(arr.get(i-1)<arr.get(i)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return true;
        ArrayList<Integer> arr=new ArrayList<>();
        inOrder(root,arr);
        return checkSortArr(arr);
    }
}