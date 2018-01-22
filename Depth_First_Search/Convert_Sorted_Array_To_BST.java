
/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head = tree(nums, 0, nums.length - 1);
        return head;
    }
    
    public static TreeNode tree(int[] nums, int low, int high){
        if (low > high)
            return null;
        
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = tree(nums, low, mid - 1);
        node.right = tree(nums, mid + 1, high);
        
        return node;
    }
}