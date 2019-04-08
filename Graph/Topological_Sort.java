
// A Java program to print topological sorting of a DAG 
import java.io.*; 
import java.util.*; 
  
// This class represents a directed graph using adjacency 
// list representation 
class Graph 
{ 
    private int V;   // No. of vertices 
    private ArrayList<Integer> adj[]; // Adjacency List 
  
    //Constructor 
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new ArrayList(); 
    } 
  
    // Function to add an edge into the graph 
    void addEdge(int v,int w) { adj[v].add(w); } 
  
    // A recursive function used by topologicalSort 
    void topologicalSortUtil(int v, boolean visited[], Stack stack) 
    { 
        // Mark the current node as visited. 
        visited[v] = true; 
  
        // Recur for all the vertices adjacent to this 
        // vertex 
        for(int i : adj[v])
        { 
            if (!visited[i]) 
                topologicalSortUtil(i, visited, stack); 
        } 
  
        // Push current vertex to stack which stores result 
        stack.push(i); 
    } 
  
    // The function to do Topological Sort. It uses 
    // recursive topologicalSortUtil() 
    void topologicalSort() 
    { 
        Stack stack = new Stack(); 
  
        // Mark all the vertices as not visited 
        boolean visited[] = new boolean[V]; 
        Arrays.fill(visited, false); 
  
        // Call the recursive helper function to store 
        // Topological Sort starting from all vertices 
        // one by one 
        for (int i = 0; i < V; i++) 
            if (visited[i] == false) 
                topologicalSortUtil(i, visited, stack); 
  
        // Print contents of stack 
        while (!stack.empty()) 
            System.out.print(stack.pop() + " "); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
        Graph g = new Graph(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
  
        System.out.println("Following is a Topological " + 
                           "sort of the given graph"); 
        g.topologicalSort(); 
    } 
} 