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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> pq=new LinkedList();
        if(root==null)return 0;
        pq.add(root);
        int max=Integer.MIN_VALUE;
        int level=1,maxlevel=1;
        while(!pq.isEmpty()){
            int s=pq.size();
            int sum=0;
            for(int i=0;i<s;i++){
                TreeNode node=pq.remove();
                sum+=node.val;
                if(node.left!=null)pq.add(node.left);
                if(node.right!=null)pq.add(node.right);
            }
           if(sum>max){
               max=sum;
               maxlevel=level;
           }
          level++;
        }
        return maxlevel;

    }
}