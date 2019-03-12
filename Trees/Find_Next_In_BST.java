
// Write an algorithm to find the "next" ndoe (in-order successor) of a given node in a 
// binary search tree. you may assume that each node has a link to its parents.


// Solution: if node has right child then return the left most child of the right child
//              or else find the parents that is a left child 
class Solution{

	TreeNode inOrderSuccessor(TreeNode root){
		if (root == null)
			return null;

		if(root.right != null){ // find the left most child of the right sub tree
			root = root.right;
			while(root.left != null){
				root = root.left;
			}
			return root;
		}
		else { // find the first parent that is a left child (of its parent)
			TreeNode par = root.parent;

			while(pat != null && par.left != root){
				root = par;
				par = par.parent;
			}
			return par;
		}
	}
}