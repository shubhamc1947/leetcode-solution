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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ls=new ArrayList<>();
        Queue<TreeNode>que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            double currSum=0;
            for(int i=1;i<=size;i++){
                TreeNode curr=que.remove();
                if(curr.left!=null) que.add(curr.left);
                if(curr.right!=null) que.add(curr.right);
                currSum+=curr.val;
            }
            ls.add(currSum/size);
        }
        return ls;
    }
}