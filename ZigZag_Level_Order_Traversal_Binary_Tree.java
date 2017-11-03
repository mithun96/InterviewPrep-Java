/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        bfs(root, result, 0);
        return result;
    }

    public void bfs(TreeNode root, List<List<Integer>> result, int level){
    	if(root == null){
    		return;
    	}

    	if(level >= result.size()){
    		List<Integer> newLevel = new ArrayList<>();
    		result.add(newLevel);
    	}

    	List<Integer> curList = result.get(level);
    	if(level % 2 == 0){
    		curList.add(root.val);
    	}
    	else {
    		curList.add(0, root.val);
    	} 

    	bfs(root.left, result, level + 1);
    	bfs(root.right, result, level + 1);
    }
}