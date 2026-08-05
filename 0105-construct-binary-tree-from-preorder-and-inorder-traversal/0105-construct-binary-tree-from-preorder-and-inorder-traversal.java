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
    private int findIdx(int[] arr, int left, int right, int target){
        for(int i=left; i<=right; i++){
            if(arr[i] == target) return i;
        }
        return -1;
    }

    int preIdx = 0;
    private TreeNode buildTreeRec(int[] preorder, int[] inorder, int low, int high){
        if(low > high) return null;
        TreeNode node = new TreeNode(preorder[preIdx]);
        int index = findIdx(inorder, low, high, preorder[preIdx]);
        preIdx++; 
        node.left = buildTreeRec(preorder, inorder, low, index-1);
        node.right = buildTreeRec(preorder, inorder, index+1, high);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRec(preorder, inorder, 0, inorder.length-1);
    }
}

/*
Input: preorder = [3,9,20,15,7]
        inorder = [9,3,15,20,7]
*/