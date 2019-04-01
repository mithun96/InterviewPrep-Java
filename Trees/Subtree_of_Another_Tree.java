//eBay

/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure 
and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all 
of this node's descendants. The tree s could also be considered as a subtree of itself.
*/

​/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /* Most efficent solution 

Time complexity : O(m*n). In worst case(skewed tree) traverse function takes O(m*n)O(m∗n) time.

Space complexity : O(n). The depth of the recursion tree can go upto n. n refers to the number of nodes in ss.
*/

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    
    public boolean traverse(TreeNode s,TreeNode t)
    {   
        if( s == null){
            return false;
        }

        return  (equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }

    public boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;

        if(x==null || y==null || x.val != y.val)
            return false;
        
        return equals(x.left,y.left) && equals(x.right,y.right);
    }
}


// Less efficient solution 
public class Solution {
    //HashSet < String > trees = new HashSet < > ();

    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);
        return tree1.indexOf(tree2) >= 0;
    }

    public String preorder(TreeNode t, boolean left) {
        if (t == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        return "#" + t.val + " " + preorder(t.left, true) + " " + preorder(t.right, false);
    }
}


