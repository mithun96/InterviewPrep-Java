class ShortestPath
{

	// Check if it is possible to go to (x, y) from current position. The
	// function returns false if the cell has value 0 or already visited
	private static boolean isSafe(int mat[][], int visited[][], int x, int y)
	{
		if(x < mat.length && y < mat[0].length && x >= 0 && y >= 0 && mat[x][y] == 1 && visited[x][y] == 0)
			return true;
		else 
			return false;
	}

	// Find Shortest Possible Route in a Matrix mat from source cell (0, 0)
	// to destination cell (x, y)

	// 'min_dist' stores length of longest path from source to destination
	// found so far and 'dist' maintains length of path from source cell to
	// the current cell (i, j)

	public static int findShortestPath(int mat[][], int visited[][],
					 int i, int j, int min_dist, int dist)
	{
		// if destination is found, update min_dist
		if (i == mat.length && j == mat[0].length){
			return Integer.min(dist, min_dist);
		}

		// set (i, j) cell as visited
		visited[i][j] = 1;

		// go to bottom cell
		if (isSafe(mat, visited, i + 1, j)) {
			min_dist = findShortestPath(mat, visited, i + 1, j, min_dist, dist + 1);
		}

		// go to right cell
		if (isSafe(mat, visited, i, j + 1)) {
			min_dist = findShortestPath(mat, visited, i, j + 1, min_dist, dist + 1);
		}

		// go to top cell
		if (isSafe(mat, visited, i - 1, j)) {
			min_dist = findShortestPath(mat, visited, i - 1, j, min_dist, dist + 1);
		}

		// go to left cell
		if (isSafe(mat, visited, i, j - 1)) {
			min_dist = findShortestPath(mat, visited, i, j - 1, min_dist, dist + 1);
		}

		// Backtrack - Remove (i, j) from visited matrix
		visited[i][j] = 0;

		return min_dist;
	}

	public static void main(String[] args)
	{
		int mat[][] =
		{
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
		};

		// construct a matrix to keep track of visited cells
		int[][] visited = new int[10][10];

		int min_dist = findShortestPath(mat, visited, 0, 0, Integer.MAX_VALUE, 0);

		if(min_dist != Integer.MAX_VALUE) {
			System.out.println("The shortest path from source to destination "
							  + "has length " + min_dist);
		}
		else {
			System.out.println("Destination can't be reached from source");
		}
	}
}