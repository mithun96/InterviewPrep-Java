
# Data Structures

## Hash Table

- Does not sort or order data
	Used when data does not need to be sorted
- Random Access ==> O(1)
- can add and remove easily 
- Fast look up and access using hash function 
- Hash Function 
	- Uses all of the data 
	- Consistant = same result everything 
	- Less collision/ big range
	- Similar data are far apart 
If collision with hash function then:
	- Linear Probing = put in next index
	- Quadratic Probing = take original index + succsive value 
		hash(x, i) = (hash(x) + foo(i)) % size 
			foo(i) = i^2

## Linked List
- Can accessa any node ==> O(n)
- can add / remove from being of the list ==> O(1)

### Runner Tecnic to find mid point
If length of the list is unknown but even, then have two iterators (runners) iterate at different paces. For example, if player1 iterates 1 node while player2 iterates 2 node, then when player2 reaches the end, player 1 is at midpoint. 

## Stack & Queue 
Stack = First in, Last out
Queue = First in, First out
- constant time to add and remove 
- useful in recursion algorithms 
- popular functions: pop(), push(), peek(), isEmpty()
- Stack is used for receusion memory 
- Queue is used for Breath First Search (BFS)
- Stack and Queue can be implemented by array or linked list

## Trees (Binary Tree)
- Tree is composed of nodse 
	- Root node - has zero or more child nodes 
- No cycles

### Binary Search Tree
	is ordered tree
	left is less than parent 
	right is greater than partent 

### AVL & Splay Tree
	Is self balancing tree

### Red-Black Tree
	Self balancing binary tree

### Binary Tree
	Complete = all levels are filled (left -> right)
	Full = each node only has zero or 2 childs
	perfect = complete + full 

Tree Traversal of BST
	inOrder(Node n){
		inOrder(n.left);
		print(n);
		inOrder(n.right);
	}

	preOrder(Node n){
		print(n);
		inOrder(n.left);
		inOrder(n.right);
	}
	postOrder(Node n){
		inOrder(n.left);
		inOrder(n.right);
		print(n);

	}


## Binary Heap 
- parent is smlller than child
- Self ordering tree

## Tries (Prefix tree)
- n-ary tree
- each node represent a letter
- each path represents a word
- * node represent end of a word (Terminate)
- is used to look up prefix and autocomplete
	- hash table can tell is word exists, not predict
- O(k), k = # of chars in string (same as hash table)

## Graphs
- Tree is a graph but graph is not a tree
- graph is a collection of nodes with edges btetween
	- can be directed or undirected edges 
- Acyclic graphs do not have cycles
- Represented by Adjacency List/ Matrix 
- Searching a grpah
	Depth First Search - Used for shortest path between two nodes
	Breath First search






	