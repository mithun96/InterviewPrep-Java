/**
 *  Find if a path exists from top left corner of given 2D array map, considering
 *  1 as path and 0 as walls, to the position where 'X' is placed.
 *
 *  This program uses Breadth-First search, and marks current position as '0' to mark
 *  it as visited point.
 *
 *  @author: Jayesh Chandrapal
 */

import java.util.*;
import java.lang.*;

class Node {
    int x;
    int y;
    int dist;
    
    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Rextester
{  
    public static void main(String args[])
    {
        char[][] matrix = {
            {'1', '0', '1', '1'},
            {'1', '1', '1', '1'},
            {'1', '1', '1', '1'},
            {'1', '1', '1', 'X'}
        };
        
        int length = shortestPathLenght(matrix);
        
        System.out.println("Shortest Path length: " + length);
    }
    
    public static int shortestPathLenght(char[][] matrix) {
        int N = matrix.length;
        
        List<Node> queue = new ArrayList<Node>();
        queue.add(new Node(0, 0, 0));

        // bool[][] visited = new bool[matrix.length][matrix[0].length];

        while(!queue.isEmpty()) {
            Node current = queue.remove(0);
            
            if(current.x == matrix.length && current.y == matrix[0].length) {
                return current.dist;
            }
            
            matrix[current.x][current.y] = '0'; // mark as visited
            // visited[current.x][current.y] = true;
            
            List<Node> neighbors = getNeighbors(matrix, current);
            queue.addAll(neighbors);
        }
        
        return pathExists;
    }
    
    public static List<Node> getNeighbors(char[][] matrix, Node node) {
        List<Node> neighbors = new ArrayList<Node>();
        
        if(isValidPoint(matrix, node.x - 1, node.y)) {
            neighbors.add(new Node(node.x - 1, node.y, node.dist + 1));
        }
        
        if(isValidPoint(matrix, node.x + 1, node.y)) {
            neighbors.add(new Node(node.x + 1, node.y, node.dist + 1));
        }
        
        if(isValidPoint(matrix, node.x, node.y - 1)) {
            neighbors.add(new Node(node.x, node.y - 1, node.dist + 1));
        }
        
        if(isValidPoint(matrix, node.x, node.y + 1)) {
            neighbors.add(new Node(node.x, node.y + 1, node.dist + 1));
        }
        
        return neighbors;
    }
    
    public static boolean isValidPoint(char[][] matrix, int x, int y) {
        // Check if point is in bounds and not a blocker
        return !(x < 0 || x >= matrix.length || y < 0 || y >= matrix.length) && (matrix[x][y] != '0');
    }
}