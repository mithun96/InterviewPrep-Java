# Concept 

Dynamic Programming is mainly an optimization over plain recursion. Wherever we see a recursive solution that has repeated calls for same inputs, we can optimize it using Dynamic Programming. The idea is to simply store the results of subproblems, so that we do not have to re-comupute them when needed later.

## How to Solve DP Problem?
### Step 1 : How to classify a problem as a Dynamic Programming Problem?

- Typically, all the problems that require to maximize or minimize certain quantity or counting problems that say to count the arrangements under certain condition or certain probability problems can be solved by using Dynamic Programming.
- All dynamic programming problems satisfy the overlapping subproblems property and most of the classic dynamic problems also satisfy the optimal substructure property. Once, we observe these properties in a given problem, be sure that it can be solved using DP.


### Step 2 : Deciding the state
DP problems are all about state and their transition. This is the most basic step which must be done very carefully because the state transition depends on the choice of state definition you make. So, let’s see what do we mean by the term “state”.

State A state can be defined as the set of parameters that can uniquely identify a certain position or standing in the given problem. This set of parameters should be as small as possible to reduce state space.

For example: In our famous Knapsack problem, we define our state by two parameters index and weight i.e DP[index][weight]. Here DP[index][weight] tells us the maximum profit it can make by taking items from range 0 to index having the capacity of sack to be weight. Therefore, here the parameters index and weight together can uniquely identify a subproblem for the knapsack problem.

### Step 3 : Formulating a relation among the states
This part is the hardest part of for solving a DP problem and requires a lot of intuition, observation and practice.

<pre><code>
// Returns the number of arrangements to  
// form 'n'  
int solve(int n) 
{  
   // base case 
   if (n < 0)  
      return 0; 
   if (n == 0)   
      return 1;   
  
   return solve(n-1) + solve(n-3) + solve(n-5); 
}  
</code></pre>>   

### Step 4 : Adding memoization or tabulation for the state
This is the easiest part of a dynamic programming solution. We just need to store the state answer so that next time that state is required, we can directly use it from our memory

Adding memoization to the above code
<pre><code>
// initialize to -1 
int dp[MAXN]; 
  
// this function returns the number of  
// arrangements to form 'n'  
int solve(int n) 
{  
  // base case 
  if (n < 0)   
      return 0; 
  if (n == 0)   
      return 1; 
  
  // checking if already calculated 
  if (dp[n]!=-1)  
      return dp[n]; 
  
  // storing the result and returning 
  return dp[n] = solve(n-1) + solve(n-3) + solve(n-5); 
}
</code></pre>
Another way is to add tabulation and make solution iterative. Please refer tabulation and memoization for more details.


## Tabulation vs Memoizatation

###. Tabulation: Bottom Up 

Let’s describe a state for our DP problem to be dp[x] with dp[0] as base state and dp[n] as our destination state. So,  we need to find the value of destination state i.e dp[n].
If we start our transition from our base state i.e dp[0] and follow our state transition relation to reach our destination state dp[n], we call it Bottom Up approach as it is quite clear that we started our transition from the bottom base state and reached the top most desired state.

Example:
<pre><code>
// Tabulated version to find factorial x.
int dp[MAXN];

// base case
int dp[0] = 1;
for (int i = 1; i< =n; i++)
{
    dp[i] = dp[i-1] * i;
}
</code></pre>

The dp table is being populated sequentially and we are directly accessing the calculated states from the table itself and hence, we call it tabulation method.

### Memoization: Top Down (Similar to Recursion)

Once, again let’s describe it in terms of state transition. If we need to find the value for some state say dp[n] and instead of starting from the base state that i.e dp[0] we ask our answer from the states that can reach the destination state dp[n] following the state transition relation, then it is the top-down fashion of DP.

Example:
<pre><code>
// Memoized version to find factorial x.
// To speed up we store the values
// of calculated states

// initialized to -1
int dp[MAXN]

// return fact x!
int solve(int x)
{
    if (x==0)
        return 1;
    if (dp[x]!=-1)
        return dp[x];
    return (dp[x] = x * solve(x-1));
}
</code></pre>

### Comparsion table:
https://www.geeksforgeeks.org/wp-content/uploads/Tabulation-vs-Memoization-1.png

Both Tabulated and Memoized store the solutions of subproblems. In Memoized version, table is filled on demand while in Tabulated version, starting from the first entry, all entries are filled one by one. Unlike the Tabulated version, all entries of the lookup table are not necessarily filled in Memoized version. 

## Overlapping SubProblems 
Like Divide and Conquer, Dynamic Programming combines solutions to sub-problems. Dynamic Programming is mainly used when solutions of same subproblems are needed again and again. In dynamic programming, computed solutions to subproblems are stored in a table so that these don’t have to be recomputed. So Dynamic Programming is not useful when there are no common (overlapping) subproblems because there is no point storing the solutions if they are not needed again. For example, Binary Search doesn’t have common subproblems. If we take an example of following recursive program for Fibonacci Numbers, there are many subproblems which are solved again and again.

## Optimal SubStructure 

A given problems has Optimal Substructure Property if optimal solution of the given problem can be obtained by using optimal solutions of its subproblems.

For example, the Shortest Path problem has following optimal substructure property:
If a node x lies in the shortest path from a source node u to destination node v then the shortest path from u to v is combination of shortest path from u to x and shortest path from x to v.

On the other hand, the Longest Path problem doesn’t have the Optimal Substructure property. Here by Longest Path we mean longest simple path (path without cycle) between two nodes. Consider the following unweighted graph given in the CLRS book (4 corner - Square). There are two longest paths from q to t: q→r→t and q→s→t. Unlike shortest paths, these longest paths do not have the optimal substructure property. For example, the longest path q→r→t is not a combination of longest path from q to r and longest path from r to t, because the longest path from q to r is q→s→t→r and the longest path from r to t is r→q→s→t.



























