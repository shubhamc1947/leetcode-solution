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
 class Pair{
    int x;
    TreeNode node;
    public Pair(int x, TreeNode node){
        this.x=x;
        this.node=node;
    }
 }
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        Queue<Pair> que=new LinkedList<>();
        que.add(new Pair(0,root));
        while(!que.isEmpty()){
            Pair curr=que.remove();
            int currX=curr.x;
            TreeNode currN=curr.node;
            tm.put(currX,currN.val);
            if(currN.left!=null){
                que.add(new Pair(currX+1,currN.left));
            }
            if(currN.right!=null){
                que.add(new Pair(currX+1,currN.right));
            }
        }
        return new ArrayList<>(tm.values());
    }
}