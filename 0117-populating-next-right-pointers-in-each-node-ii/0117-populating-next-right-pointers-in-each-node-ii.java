/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/



class Solution {
    public Node connect(Node root) {
        if(root == null)return null;

        Node node = null;
        if(root.left == null && root.right==null)
            return root;
        else if(root.right != null && root.left != null){
            root.left.next = root.right;
            node = root.right;
        }else node = root.left != null? root.left: root.right;


        Node next = null;
        Node curr = root.next;
        while(curr!=null){
            if(curr.left!=null){
                next = curr.left;
                break;
            }else if(curr.right != null){
                next = curr.right;
                break;
            }
            curr = curr.next;
        }

        node.next = next;
        connect(root.right);
        connect(root.left);
        return root;
    }
}