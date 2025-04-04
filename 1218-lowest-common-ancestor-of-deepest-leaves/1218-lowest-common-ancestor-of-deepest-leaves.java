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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // if(root==null) return root;
        // if(root.left==null && root.right==null) return root;
        Queue<TreeNode> q=new ArrayDeque<>();
        List<TreeNode> arr=new ArrayList<>();
        if(root!=null)
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            arr=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode n=q.poll();
                arr.add(n);
                if(n.left!=null)
                q.add(n.left);
                if(n.right!=null)
                q.add(n.right);
            }
        }
        if(arr.size()==1) return arr.get(0);
        return func(root,arr);
        
    }
    public TreeNode func(TreeNode root,List<TreeNode> arr)
    {
               if(root==null) return null;
               for(int i=0;i<arr.size();i++)
               {
                if(arr.get(i)==root) return root;
               }

               TreeNode left=func(root.left,arr);
               TreeNode right=func(root.right,arr);
               if(left!=null && right!=null) return root;
               if(left==null) return right;
               return left;
    }
}