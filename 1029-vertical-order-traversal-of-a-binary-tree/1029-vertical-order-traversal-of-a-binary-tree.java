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
 class Tuple{
        TreeNode node;
        int row;
        int col;
        public Tuple(TreeNode node,int row, int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }
class Solution {
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap<>();

        Queue<Tuple> que=new LinkedList<>();

        que.add(new Tuple(root,0,0));

        while(!que.isEmpty()){
            Tuple curr=que.remove();
            TreeNode currN=curr.node;
            int x=curr.row;
            int y=curr.col;
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).add(currN.val);

            if(currN.left!=null){
                que.add(new Tuple(currN.left,x-1,y+1));
            }
            if(currN.right!=null){
                que.add(new Tuple(currN.right,x+1,y+1));
            }
        }
        System.out.println(map);

        List<List<Integer>> list=new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes :ys.values()){
                while(!nodes.isEmpty()){
                    System.out.println(nodes.peek());
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}