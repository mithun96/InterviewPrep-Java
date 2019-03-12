/* Question 

Program for nth Catalan Number
Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems like following.
1) Count the number of expressions containing n pairs of parentheses which are correctly matched. 
For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).

2) Count the number of possible Binary Search Trees with n keys (See this)

3) Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children or no children) with n+1 leaves.

See this for more applications.



The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …

*/


// USING RECURSION 
class CatalnNumber { 
  
    // A recursive function to find nth catalan number 
  
    int calCatalan(int n) { 
        int res = 0; 
          
        // Base case 
        if (n <= 1) { 
            return 1; 
        } 
        for (int i = 0; i < n; i++) { 
            res += calCatalan(i) * calCatalan(n - i - 1); 
        } 
        return res; 
    } 
  
    public static void main(String[] args) { 
        CatalnNumber cn = new CatalnNumber(); 
        for (int i = 0; i < 10; i++) { 
            System.out.print(calCatalan(i) + " "); 
        } 
    } 
} 


// USING Dynamic Programming 
class CatalnNumber { 
  
    // A recursive function to find nth catalan number 
  
    public static int calCatalan(int n) { 
        int catalan[] = new int[n+1];
        catalan[0] = 1;
        catalan[1] = 1;

        for (int i = 2; i < n; i++) { 
        	catalan[i] = 0;
        	for(int j = 0; j < i; j++){
        		catalan[i] += catalan[j] * catalan[i - j - 1];
        	}
        } 
        return catalan[n]; 
    } 
  
    public static void main(String[] args) { 
        for (int i = 0; i < 10; i++) { 
            System.out.print(calCatalan(i) + " "); 
        } 
    } 
} 








