/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    class TreeInfo{
        TreeNode ans;
        boolean pFound;
        boolean qFound;

        TreeInfo(TreeNode ans, boolean pFound, boolean qFound){
            this.ans = ans;
            this.pFound = pFound;
            this.qFound = qFound;
        }
    }

    public TreeInfo dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return new TreeInfo(null, false, false);

        TreeInfo left = dfs(root.left, p, q);
        if(left.ans != null) return new TreeInfo(left.ans, true, true);

        TreeInfo right = dfs(root.right, p, q);
        if(right.ans != null) return new TreeInfo(right.ans, true, true);

        if((left.pFound||right.pFound) && (left.qFound||right.qFound)){
            return new TreeInfo(root, true, true);
        }

        if(root==p){
            if(left.qFound || right.qFound){
                return new TreeInfo(root, true, true);
            }
            return new TreeInfo(null, true, false);
        }

        if(root==q){
            if(left.pFound || right.pFound){
                return new TreeInfo(root, true, true);
            }
            return new TreeInfo(null, false, true);
        }

        return new TreeInfo(null, left.pFound || right.pFound, left.qFound || right.qFound);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q).ans;
    }
}