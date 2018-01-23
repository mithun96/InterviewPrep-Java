/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) 
        	return true;

        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right){

    	if (left == null || right == null)
    		return left == right;

    	if(left.val != right.val)
    		return false;

    	boolean leftCheck = check(left.left, right.right);
    	boolean rightCheck = check(left.right, right.left);

    	return leftCheck && rightCheck;

    }
}