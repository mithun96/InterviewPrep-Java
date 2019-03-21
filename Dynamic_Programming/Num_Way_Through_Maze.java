
/* https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/

Given a maze with obstacles, count number of paths to reach rightmost-bottommost cell from topmost-leftmost cell. 
A cell in given maze has value -1 if it is a blockage or dead end, else 0.

From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only.
*/



/* Explaination

The idea is to modify the given grid[][] so that grid[i][j] contains count of paths to 
reach (i, j) from (0, 0) if (i, j) is not a blockage, else grid[i][j] remains -1.
*/

// Using Dynanmic Programming to Solve. DFS is too slow!!
import java.io.*; 
  
class GFG  
{ 
      
    // Returns count of possible paths in  
    // a maze[R][C] from (0,0) to (R-1,C-1) 
    static int countPaths(int maze[][]) 
    { 
        // If the initial cell is blocked,  
        // there is no way of moving anywhere 
        if (maze[0][0]==-1) 
            return 0; 

        // Set origin to 1
        maze[0][0] = 1;


        // // Initializing the leftmost column 
        // for (int i = 0; i < R; i++) 
        // { 
        //     if (maze[i][0] == 0) 
        //         maze[i][0] = 1; 
      
        //     // If we encounter a blocked cell  
        //     // in leftmost row, there is no way  
        //     // of visiting any cell directly below it. 
        //     else
        //         break; 
        // } 
      
        // // Similarly initialize the topmost row 
        // for (int i =1 ; i< C ; i++) 
        // { 
        //     if (maze[0][i] == 0) 
        //         maze[0][i] = 1; 
      
        //     // If we encounter a blocked cell in  
        //     // bottommost row, there is no way of  
        //     // visiting any cell directly below it. 
        //     else
        //         break; 
        // } 


      
        // The only difference is that if a cell  
        // is -1, simply ignore it else recursively  
        // compute count value maze[i][j] 
        for (int i = 0; i < maze.length; i++) 
        { 
            for (int j = 0; j < maze[0].length; j++) 
            { 
                // If blockage is found,  
                // ignore this cell  
                if (maze[i][j] == -1) 
                    continue; 
      
                // If we can reach  maze[i][j] from  
                // maze[i-1][j] then increment count. 
                if (i - 1 >= 0 && maze[i - 1][j] > 0) 
                    maze[i][j] = (maze[i][j] + maze[i - 1][j]); 
      
                // If we can reach maze[i][j] from 
                //  maze[i][j-1] then increment count. 
                if (j - 1 >= 0 && maze[i][j - 1] > 0) 
                    maze[i][j] = (maze[i][j] + maze[i][j - 1]); 
            } 
        } 
      
        // If the final cell is blocked,  
        // output 0, otherwise the answer 
        return (maze[R - 1][C - 1] > 0) ?  
                maze[R - 1][C - 1] : 0; 
    } 
      
    // Driver code 
  
    public static void main (String[] args)  
    { 
        int maze[][] = {{0, 0, 0, 0}, 
                       {0, -1, 0, 0}, 
                       {-1, 0, 0, 0}, 
                       {0, 0, 0, 0}}; 
        System.out.println (countPaths(maze)); 
      
    } 

    // Solution use DFS!! (Slower than DP)
    public static int countDFS(int[][] maze, int i, int j){
        if(!isValid(maze, i, j)){
            return 0;
        }

        if(i == maze.length -1 && j == maze[0].length -1){
            return 1;
        }

        int ans = 0; 
        ans = ans + countDFS(maze, i + 1, j);
        ans = ans + countDFS(maze, i, j + 1);

        return ans;
    }

    public static boolean isValid(int[][] maze, int i, int j){
        if(i >= 0 && i < maze.length && j >=0 && j < maze[0].length && maze[i][j] == 0){
            return true;
        }
        return false;
    }
} 
  