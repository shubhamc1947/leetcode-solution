/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneUtils(Node node,HashMap<Node,Node> hm){
        Node newNode=new Node(node.val);
        hm.put(node,newNode);

        for(Node neighbour: node.neighbors){
            if(!hm.containsKey(neighbour)){
                //first time
                newNode.neighbors.add(cloneUtils(neighbour,hm));
            }else{
                newNode.neighbors.add(hm.get(neighbour));
            }
        }
        return newNode;

    }
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node,Node> hm=new HashMap<>();
        return cloneUtils(node,hm);
    }
}