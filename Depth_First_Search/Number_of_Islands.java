
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally 
or vertically. You may assume all four edges of the grid are all surrounded by water.
*/


// Deapth First Search  (DFS)

public class Number_of_Islands {


	public int numIslands(char[][] grid) {
	    int count = 0;
	    int n = grid.length;

	    if (n == 0) 
	    	return 0;

	    int m = grid[0].length;
	    
	    for (int i = 0; i < n; i++){
	        for (int j = 0; j < m; j++)
	            if (grid[i][j] == '1') {
	                DFSMarking(grid, i, j);
	                ++count;
	            }
	    }    
	    return count;
	}

	private void DFSMarking(char[][] grid, int i, int j) {
	    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') 
        return;
	    
	    grid[i][j] = '0';
	    DFSMarking(grid, i + 1, j);
	    DFSMarking(grid, i - 1, j);
	    DFSMarking(grid, i, j + 1);
	    DFSMarking(grid, i, j - 1);
	}
}




// Breath First Search (BFS)
class Solution {
  class Node {
    int x;
    int y;
    public Node(int i, int j){
      x = i;
      y = j;
    }
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0;

    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == '1') {
          ++num_islands;
          grid[r][c] = '0'; // mark as visited
          
          Queue<Node> neighbors = new LinkedList<>();
          neighbors.add(new Node(r, c));

          while (!neighbors.isEmpty()) {
            Node node = neighbors.remove();
            int row = node.x;
            int col = node.y;
            if (row - 1 >= 0 && grid[row-1][col] == '1') {
              neighbors.add(new Node(row - 1, col));
              grid[row-1][col] = '0';
            }
            if (row + 1 < nr && grid[row+1][col] == '1') {
              neighbors.add(new Node(row + 1, col));
              grid[row+1][col] = '0';
            }
            if (col - 1 >= 0 && grid[row][col-1] == '1') {
              neighbors.add(new Node(row, col - 1));
              grid[row][col-1] = '0';
            }
            if (col + 1 < nc && grid[row][col+1] == '1') {
              neighbors.add(new Node(row, col + 1));
              grid[row][col+1] = '0';
            }
          }
        }
      }
    }

    return num_islands;
  }
}
