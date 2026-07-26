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

    class Hd {
        int maxD;
        int height;

        Hd(){
            maxD = 0;
            height = 0;
        }

        Hd(int maxD, int height){
            this.maxD = maxD;
            this.height = height;
        }
    }

    public Hd diameterOfBinaryTree1(TreeNode root) {
        if(root == null) return new Hd();

        Hd leftHd = diameterOfBinaryTree1(root.left);
        Hd rightHd = diameterOfBinaryTree1(root.right);

        int newHeight = 1 + Integer.max(leftHd.height, rightHd.height);
        int newDia = leftHd.height + rightHd.height;
        int newlrMaxDia = Integer.max(leftHd.maxD, rightHd.maxD);
        int newMaxDia = Integer.max(newDia, newlrMaxDia);

        return new Hd(newMaxDia, newHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTree1(root).maxD;
    }
}