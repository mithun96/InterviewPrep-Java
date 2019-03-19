
/*
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of 
the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then 
sum node values up as the new value of the merged node. 
Otherwise, the NOT null node will be used as the node of new tree.
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;w
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        if (t1 == null && t2 == null)
            return null;
            
        TreeNode temp= new TreeNode(0);
        
        if (t1 != null)
            temp.val += t1.val;
            
        if (t2 != null)
            temp.val += t2.val;
        
        
        temp.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        temp.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
            
        return temp;
    }
}


