import java.util.*;

public class Solution {

	public static void main(String[] args) {


		// String[][] grid = new String[][]{[["1","0","1","1","0"],["1","1","0","1","0"],["1","1","0","0","1"],["0","0","0","0","0"]]};

		return;
	}

	public int numIslands(char[][] grid) {

		int result = 0;

		int m = grid.length;
		if (m == 0)
			return result;

		int n = grid[0].length;

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++){
				if(grid[i][j] == '0'){
					continue;
				} 

				if((i - 1 >= 0 && grid[i - 1][j] == '1') || (j - 1 >= 0 && grid[i][j - 1] == '1')) {
					continue;
				}

				result++;
			}
		}
		return result;
	}



	public TreeNode search(TreeNode root, int key) {
		if (root == null || root.val == key) {
			return root;
		}

		if (key > root.val){
			return search(root.right, key);
		}
		else 
			return search(root.left, key);
	}


	public int findCircleNum(int[][] M){

		int result = 0;
		boolean[] visited = new boolean[M.length];
		Arrays.fill(visited, false);

		for(int i = 0; i < M.length; i++){
			if(visited[i] == false){
				dfs(M, visited, i);
			}
		}

		return result;

	}

	public void dfs(int[][] M, boolean[] visited, int i){

		for(int j = 0; j < M.length; j++){
			if(M[i][j] == 1 && visited[j] == false){
				visited[j] = true;
				dfs(M, visited, j);
			}
		}
	}























	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		bsf(root, result, 0);
		return result;
	}

	public void bsf(TreeNode root, List<List<Integer>> result, int level){
		if (root == null){
			return;
		}


		if (result.size() <= level) {
			List<Integer> nextLevel = new ArrayList<>();
			result.add(nextLevel);
		}
		
		List<Integer> curLevel = result.get(level);

		if (level % 2 == 0) {
			curLevel.add(root.val);
		}
		else{
			curLevel.add(0, root.val);
		}

		bsf(root.left, result, level + 1);
		bsf(root.right, result, level + 1);
	}

}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}