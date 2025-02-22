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
   public int nodeIndex = 1;
public TreeNode recoverFromPreorder(String S) {
    List<Integer> decodeRes = decodeString(S);
    TreeNode res = new TreeNode(decodeRes.get(1));
    dfs(res, decodeRes, 0);
    return res;
}

private int dfs(TreeNode node, List<Integer> decodeRes, int beforeDepth) {
	int index = 2 * nodeIndex;
	if (index + 1 > decodeRes.size()) {
		return -1;
	}
	int depth = decodeRes.get(index);
	int returnDepth = depth;
	if (depth == beforeDepth + 1) {
		node.left = new TreeNode(decodeRes.get(index + 1));
		nodeIndex++;
		returnDepth = dfs(node.left, decodeRes, depth);
	}
	if (returnDepth == beforeDepth + 1) {
		node.right = new TreeNode(decodeRes.get(nodeIndex * 2 + 1));
		nodeIndex++;
		returnDepth = dfs(node.right, decodeRes, returnDepth);
	}
	return returnDepth;
}
//decode string return list,odd index is node depth,even index is node value.
public List<Integer> decodeString(String S) {
    List<Integer> res = new ArrayList<>();
    res.add(0);
    int depth, val;
    for (int i = 0; i < S.length(); ) {
        for (depth = 0; S.charAt(i) == '-'; i++) {
            depth++;
        }
        if (depth != 0) {
            res.add(depth);
        }
        for (val = 0; i < S.length() && S.charAt(i) != '-'; i++) {
            val = val * 10 + (S.charAt(i) - '0');
        }
        res.add(val);
    }
    return res;
}
}