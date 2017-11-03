
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally 
or vertically. You may assume all four edges of the grid are all surrounded by water.
*/



class Solution1{
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0)
        	return 0;

        int n = grid[0].length;

        int result = 0;

        for(int i = 0; i < m; i++){
        	for (int j = 0; j < n; j++) {
        		
        		//If not a 1, then go to the next block. 
        		if(grid[i][j] == '0')
        			continue;

        		//If the above is a 1 then go to the next block because that island is already account for. 
        		if(i > 0 && grid[i - 1][j] == '1' )
        			continue;

        		//If the left is a 1 then go to the next block because that island is already account for. 
        		if(j > 0 && grid[i][j - 1] == '1' )  
        			continue;

        		result++;
        	}
        }
        return result;
    }
}





public class Solution2 {

private int n;
private int m;

public int numIslands(char[][] grid) {
    int count = 0;
    n = grid.length;
    if (n == 0) return 0;
    m = grid[0].length;
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
    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
    grid[i][j] = '0';
    DFSMarking(grid, i + 1, j);
    DFSMarking(grid, i - 1, j);
    DFSMarking(grid, i, j + 1);
    DFSMarking(grid, i, j - 1);
}