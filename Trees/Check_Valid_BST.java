

// Implement a function to check if a binary tree is a binary search tree

// solution: using min and max value of the node 
class Solution{

	boolean checkBST(TreeNode root){
		return checkBST(root, null, null)
	}

	boolean checkBST(TreeNode root, int min, int max){
		// Corner Case
		if(root == null){
			true;
		}

		// Base case
		if((min != null && root.val <= min) || (max != null && root.val > max)){
			return false;
		}

		if(root.left != null)
			boolean left = checkBST(root.left, min, root.val);
		
		if(root.right != null)
			boolean right = checkBST(root.right, root.val, max);

		if(left && right)
			return true;
		else 
			return false;
	}
}