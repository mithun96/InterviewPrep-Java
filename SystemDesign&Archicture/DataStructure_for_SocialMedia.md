# Question: 

Design the data structures for a very large social network. Describe how you would design an algorithm to show the connection, or path, between two people (e g , Me -> Kumar-> Verma-> Atul-> You)?

## Approach: 

Forget that we’re dealing with millions of users at first Design this for the simple case.

We can construct a graph by assuming every person is a node and if there is an edge between two nodes, then the two people are friends with each other class Person { Person[] friends; // Other info }

If I want to find the connection between two people, I would start with one person and do a simple breadth first search But… oh no! Millions of users! When we deal with large social network, means that our simple Person data structure from above doesn’t quite work — our friends may not live on the same machine as us.

Instead, we can replace our list of friends with a list of their IDs, and traverse as follows:

1. For each friend ID: int machineID = lookupMachineForUserID(id);

2. Person friend = lookupFriend(machineID, ID);

There are more optimizations and follow up questions here than we could possibly discuss, but here are just a few thoughts:

## Optimization: 
Reduce Machine Jumps, Jumping from one machine to another is expensive Instead of randomly jumping from machine to machine with each friend, try to batch these jumps — e g , if 5 of my friends live on one machine, I should look them up all at once Optimization: Smart Division of People and Machines People are much more likely to be friends with people who live in the same country as them Rather than randomly dividing people up across machines, try to divvy them up by country, city, state, etc This will reduce the number of jumps

## Follow up Question: 

Breadth First Search usually requires “marking” a node as visited. How do you do that in this case?

### Approach: 
Usually, in BFS, we mark a node as visited by setting a flag visited in its node class. Here, we don’t want to do that (there could be multiple searches going on at the same time, so it’s bad to just edit our data) In this case, we could mimic the marking of nodes with a hash table to lookup a node id and whether or not it’s been visited.


## Other Follow-Up Questions: 
1. In the real world, servers fail, How does this affect you? 
2. How could you take advantage of caching? 
3. Do you search until the end of the graph (infinite)? How do you decide when to give up?
4. In real life, some people have more friends of friends than others, and are therefore more likely to make a path between you and someone else How could you use this data to pick where you start traversing?