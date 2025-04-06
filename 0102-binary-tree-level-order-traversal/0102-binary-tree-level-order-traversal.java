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
    public static class Pair{
        TreeNode node;
        int level;
        public Pair(TreeNode node,int level){
            this.node=node;
            this.level=level;
        }
    }
    static int levels(TreeNode root){
        if(root==null)return 0;
        return 1+Math.max(levels(root.left),levels(root.right));
    }
    static void BFS(TreeNode root,List<List<Integer>>list){
        Queue<Pair>queue=new ArrayDeque<>();
        if(root!=null)queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair front=queue.remove();
            list.get(front.level).add(front.node.val);
            if(front.node.left!=null)queue.add(new Pair(front.node.left,front.level+1));
            if(front.node.right!=null)queue.add(new Pair(front.node.right,front.level+1));
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>list=new ArrayList<>();
        int level=levels(root);
        for(int i=0;i<level;i++){
            List<Integer>lst=new ArrayList<>();
            list.add(lst);
        }
        BFS(root,list);
        return list;
    }
}