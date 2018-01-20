# Chapter 5: Bit Manipulation 

**SKIPPED**

# Chapter 6: 

**SKIPPED**

# Chapter 7: Object Oriented Design

## How to approach:
1. Handle ambiguity 
	ask who will use and how they will use it 
2. Define core objects 
	eg. Restaurant = table, host, gusts, party, order, meals ...
3. Analyze relationship between objects
4. Investigate actions of objects (functions)

## Examples of OOD

### Singleton CLass
a class had only one instance and ensures acccess to the instance through the application 
disliked because "anti-pattern" and interfere with unit testing 

### Factory Method
Offers an interface for creating an instance of a class, with its  subclasses deciding which class to instantiate. 

# Chapter 8: Recursion and Dynamic Programming 

## Recursion 

Good hint that a problem is recursive is if it can be built off of subproblems. 
Usually starts with these:
	"Design an algorthm to compute the nth ..."
	"Write code to list the first n..."
	"Implement a method to compute all .. "

### How to apprpoach:

Three of the most common approaches to develop an algorithm are:

#### 1. Bottom-Up Approach (Dynamic Programming)

We start with knowing how to solve the problem for a simple case, like a list with only one element. Then we figure out how to solve the porblem for two elements and so on. The key here is to think about how you can build the solution for one case off of the preivous case (or multiplle previous cases).

#### 2. Top-Down Approach (Memoization)

Think about how to divide the problem for case N into subproblems. => Before casreful of overlap between cases 

#### 3. Half-and-Half Approach 

To divide the data set in half. Example is merge sort or binary search tree. 

## Dynamic Programming & Memoization 

DP is mostly just a matter of taking a recusive algorithm and finding the overlapping subproblems (repeated calls). You then cache those results for future recursive calls. 

### Example of DP 

Computing the nth Fibonacci number. A good way to approach such a problem is ofern to implement it as a normal recursive soltuion and then add the caching part. 

```java
// Recursive solution 
int fib(int i){
	if (i == 0) {return 0}
	if (i == 1) {return 1}
	return fib(i - 1) + fib(1 - 2);
}
```
Has a runtime of `O(2^n)`. Each branch has two childs (two calls) => the number of nodes in the recursive tree is the runtime. 

```java
// Top-Down DP (Memoization) solution 
int fib(int i){
	return fib(i, new int[i + 1])
}

int fib(int i, int[] mem){
	if (i == 0 || i == 0) {return i;}

	if (mem[i] == 0){
		mem[i] = fib(i - 1, mem) + fib(i - 2, mem);
	}
	return mem[i];
}
```
This soultion will run in `O(n)`. If you draw the diagram, you will notice it does not recalulate cached data. 

```java
// Bottom-Up DP Solution 1

int fib(int i){
	if (i == 0 || i == 0) {return i;}

	int[] mem = new int[i];
	mem[0] = 0;
	mem[1] = 1;
	for(int i = 2; i < i; i++) {
		mem[i] = mem[i - 1] + mem[i - 2];
	}
	
	return mem[i - 1] + mem[i - 2];
}
```

```java
// Bottom-Up DP Solution 2

int fib(int i,){
	if (i == 0) {return 0;}

	a = 0;
	b = 1;
	for(int i = 2; i < n; i++) {
		c = a + b;
		a = b;
		b = c;
	}
	return a + b;
}
```

The time for the above solutions are `O(n)` and the space complexity for the second soltion much lower than the first one which has n size array.

# Chapter 9: System Designa and Scalability

There are good solutions and bad solution. There is no perfect solution 

## Handling the questions

1. Communicate: ask the interviewer questions and be open about the issues of your system. 

2. Go broad first: Don't dive straight into the algorithm part of get excessively docused on one part. 

3. Use the whiteboard: easy for the interviewer to follow along

4. Acknoledge interviews converns: Validate the interviewers concerns. Acknowledge the issues and make changes accordingly. 

5. Be careful about assumptions.

6. State your assumptioms explicitly. 

7. Estimate when necessary. 

8. Drive! As the condidate you should stay in the driver's seat. Ask questions. Be open about tradeoffs. continue to go deeper. Continue to make improvements. 

## Design: Step-By-Step

1. Scope the problem
	Write out all the steps to complete

2. Make Reasonable Assumptions 

3. Draw the major Components - the white board!! 

4. Identify the key issues 
	What are the bottlenecks or major challenges 

5. Redesign for key issues 

## Key Concepts 

1. Horizontal vs. Vertical Scalling 
	Vertical = adding more resources (increasing memory to a serve to improve its ability to handle load changes)
	Horizontal = increasing the number of nodes (more servers to decrease the load on each )

2. Load balancer This allows a system to distribute the load evenly so that one server doesn't crash and take down the whole system. However, you have to build out a netowrk of cloned servers that all have essentially the same code and access to the same data. 

3. Database Denormalization and NoSQLJoins in a relational database such as SQL can get very slow as the system grows bigger. Solution is denormalization or using NoSQL. 

4. Database Partiioning (Sharding)
sharding means splitting the data across multiple machines while ensuring you have a way to figuring out which data is on which machine. 

There multiple ways for sharding: 
Vertical partitioning
Key-Based (Hash-based) partitioning 
Directory-based Parititioning

5. Caching 
	in-memory cahche can deliver very rapid results. Simple key-value pairing and typically sits between your application layer and your data store. 

6. Asychronous Processing and Queues 

7. Networking Metrics:
	Bandwidth 
	Throughput
	Latency 

8. MapReduce 
	used to process large amount of data. associated with Google. 

Things to consider:
Failures 
Availability and Reliability 
Read-heavy vs. write heavy 
Security 

# Chapter 10: Sorting and Searching 

Many sorting and searching problem are tweaks of the well-known algorithms

## Common Sorting Algorithms 

### Bubble Sort 
Runtime: O(n^2)
Average & worst case. Memory: O(1)
compare the first pair of elements and swap and then check second pair and so on...

### Selection Sort
Runtime: O(n^2)
Average & worst case. Memory: O(1)
Find the smallest by doing a linear scan and swap with the first element and so on...

### Merge Sort 
Runtime: O(n log(n))
Average & worst case. Memory: Depends
Divide in two, sort and then merge. 

### Quick Sort 
Runtime: O(n log(n))
worst case runtime : O(n^2)
Average Memory: O(n^2)
Worst case. Memory: O(log(n))
pick a random element and partiion the array, such that all numbers that are less than the partitioning come before all elements that are gerater than it. 

### Bucket (Radix) Sort 
Runtime: O(kn) <= k is the number of passes of the sorting algorothm 
A sorting algorithm for integers that take advantage of the fact that integers have a finite number of bits. Iterate through each digit fo the number, grouping number by each digit. 

## Searching Algorithm 
Binary search. we look for an element x in a sorted array by first comparing x to the midpoint of the array. If x is less than the midpointm then we search the left half of the array. if not, we check the right half of the array. 

# Chapter 11: Testing 

## What the interviewer is looking for 

1. Big Picture Understanding: 
	Do you undersand what the software is really about?
	Can you prioritize test cases properly? 
	example: for amazon, you have to make sure that the payments goes through, orders are placed before images and buttons work. 

2. Knowing How the Piece Fit Together: 
	Do you understand how the software works? 
	How it might fit into a greater ecosystem? 
	Example: For google docs, got to test intergration with Gmail, plug-in and other components, rather than open, edit and save. 

3. Organization:
	Do you approach the problem in a structured manner? 
	Categorize tests into what the features should do. 

4. Practicality: 
	Can you actually create reasonable testing plans?
	Example: if a user reports that the software crashes when they open a specifice image, and you just tell them to install the software that is not practical. Your test need to feasible and realistic for the company to implement. 

## Questions to ask:

1. Who will use it and why ? 

2. What are the use cases?

3. What are the bounds of use? the limiations? 

4. What are the stress/ failure conditions? 

5. How would you perform the tests? 

## Testing a Function 

1. Define the test cases 
	Normal cases 
	Extremes
	Nulls and "illegal" input
	Strange input 

2. Define the expected result
	
3. Write Test Code 

# Chapter 12: C and C++

## Classes and Inheritance 
	All data members and methods are private by dafault in C++. 

```c
#include <iostream>

using namespace std;

#define NAME_SIZE 50    // Defines a macro

Class Person {
	ind id;
	char name[NAME_SIZE];

	public:
		void aboutMe() {
			cout << "I am a person";
		}
};

clss Student : public Person {
	public:
		void aboutMe() {
			cout << "I am a student";
		}
}

int main() {
	Student *p = new Student();
	p->aboutMe(); 
	delete p;      // **This is important because C++ does not have garbage collection. Have to delete allocated memory 
	return 0; 
}

```

## Constructors and Destructors
If not defined, the compiler automatically generates one called the Default Construcutor. 

```c
// Constructor 
Person(int a) {
	id = a;
}

//Destructors
~Person() {
	delete obj;  // free any memory allocationed within class
}
```

## Virtual Functions 
```c
Person *p = new Student();
p->aboutMe();        		// This will print "I am a person" because this is resolved in comiler time and it is ** STATIC BINDING
```

If we don't want the parent class's function to be called, you can make it **virtual**:
```c
Class Person {
	...
		virtual void aboutMe() {
			cout << "I am a person";
		}
};

clss Student : public Person {
	public:
		void aboutMe() {
			cout << "I am a student";
		}
}

```

 Or we can make it "pure virtual function" where there is nothing implemented:
```c
Class Person {
	...
		virtual void aboutMe() = 0;
};
```

## Operator Overloading 
Operator overloading enables us to apply operators like "+" to objects that would otherwise not support these operations. 
```c
BookShelf BookShelf::operator+(BookShelf &other) { ... }
```

## Pointers and Reference 
A pointer holds the address of a veriable and can be used to perform any operation that could be directly done on the variable such as accessing and modifying it. 
```c
int *p = new int; 
*p = 7;                 // <= Dereferencing a pointer 
int *q = p; 
*q = 8; 
cout << *p;   			// this will print 8
```

### Referenes 
a reference is another name for a pre-exisitng object and it does not ahev memory of its own. 
```c
int a = 5; 
int &b = a; 			// <= Referencing.     b is a reference to a 
int b = 8; 
cout << a;  			// this will print 8
```

You cannot creat a reference without specifying where in memory it refers to. However, you can create a free-standing as below:
```c
const int &b = 12;
```
Unlike pointers, reference cannot be null and cannot be reassigned to another piece of memory.

## Templates 

Templates are a way of reusing code to apply the same class to different data types. 
```c
template <class T> class ShiftedList {
	T* array;
	int offset, size;

	public:
		ShiftedList(int s): size(s) {
			array = new T[size];
		}
		...
}
```

# Chapter 13: Java 

## Overloading vs. Overriding 

**Overloading** is a term used to describte when two methods have the same name but differ in the type or number of arguments 
```java 
public int foo(int a, int b){...}
public int foo(int a, String b){...}
public void foo(int a, int b){...}

```

**Overriding** occurs when a method shares the same name and function signautre as another method in its supper class. 

## Collection Framework 

**ArrayList**: a dynamically resizing array, which grows as you insert elements 
```java 
ArrayList<String> myArr = new ArrayList<String>();
myArry.add("one");
myArry.add("two");
System.out.println(myArr.get(0));

```


**Vector**: similar to arrayLost, except it is synchronized.
```java 
Vector<String> myVec = new Vector<String>();
myVec.add("one");
myVec.add("two");
System.out.println(myVec.get(0));

```

**LinkedList**: Java's built-in LinkedList class. Though it rarely comes up in an interview, its userful to study because it demonstrates some of the syntax for an iterator. 
```java 
LinkedList<String> myLinkedList = new LinkedList<String>();
myLinkedList.add("one");
myLinkedList.add("two");
Iterator<String> iter = myLinkedList.iterator();
While (iter.hasNext()){
	System.out.println(iter.next());
}
```

**Hashmap**: A HashMap Collection is widely used, both in interviews and in the real world.
```java 
HashMap<String, String> myHash = new HashMap<String, String>();
myHash.put("one", "uno");
myHash.put("two", "dos");
System.out.println(myHash.get("one"));   // prints "uno"
```

# Chapter 14: Databases 

## SQL Syntax
Implicit Join:
```SQL
SELECT CourseName, TeacherName
FROM Courses, Teachers
WHERE Courses.TeacherID = Teachers.TeacherID
```

**SKIPED REST OF CHAPTER**



# Big O

## Order of complexity 

1. O(1)

2. O(log n)

3. O(n)

4. O(n log(n))

5. O(n^2)

6. O(2^n)

7. O(n!)

## Dopping Constants and Non-Dominat Terms

O(2n) becomes O(n)

O(n^2 + n) becomes O(n^2)

O(n^2 + n^2) becomes O(n^2)

O(2^n + 1000n^(100)) becomes O(2^n)


## Multi-part Algorthms

Add the Runtime: O(A + B)
```java
for(int a: arrA){
	...
}
for (int b: arrB){
	...
}
```

Multiple the Runtime: O(A * B)
```java
for(int a: arrA){
	for (int b: arrB){
		...
	}
}
```








