
/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/


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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        
        return check(root) != -1;
    }
    
    public int check(TreeNode root){
        if(root == null)
            return 0;
        
        int left = check(root.left) + 1;
        
        int right = check(root.right) + 1;
        
        if(left == -1 || right == -1)
            return -1;
        
        if(left - right < -1 || left - right > 1)
            return -1;
        
        return Math.max(right, left) + 1;
    }
}