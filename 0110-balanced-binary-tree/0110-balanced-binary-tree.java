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
    class TreeInfo{
        boolean isBalanced;
        int height;

        TreeInfo(){
            isBalanced = true;
            height = 0;
        }

        TreeInfo(boolean isBalanced, int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public TreeInfo dfs(TreeNode root) {
        if(root == null) return new TreeInfo();
        
        TreeInfo left = dfs(root.left);
        TreeInfo right = dfs(root.right);

        if(!left.isBalanced || !right.isBalanced) return new TreeInfo(false, -1);

        boolean isCurrBalanced = Math.abs(left.height - right.height) <= 1;
        int currHeight = 1 + Math.max(left.height, right.height);

        return new TreeInfo(isCurrBalanced, currHeight);
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced;
    }
}