
# System Desing and Scalability 

## Handling the Question

1. They evaluate your ability to communicate. Ask them questions and keep themengaged. 
2. Start approaching the problem broadly first
3. Use whiteboard
4. Acknowledge Interviewers converns: make changes according to the interviewers concerns
5. State your assumptions explicitly: allows interviewer to cirrect you if your mistaken. 
6. Estimate when necessary: you might not have the data you need so estimate. Eg. estimate the amount of storage need to store all the URL of your crawler...
7. Drive the interview: keep talking to the interviewer. Drive through your questions. Be open about tradeoffs. Countinue to go deeper and improvements. 


## Design: Step by Step

1. Scrope the problem. 
	- you want to ensure that your building wha the interviewer wants and is evaluating so make sure to scope the design. 
	- Make a list of features or use cases to incorpate 
2. Make Reasonable Assumption
	- Give reasons for your assumptions and keep them reasonable 
3. Draw the Major Components
	- example: frontend server (set of servers), backend data store, another server to crawl the internet and another to process and analyze. 
	- Walk throuhg the start and end process.
4. Identify the Key Issues
	- once you have a basic design, focus on the key issues. 
	- bottlenecks or major challenges in the sytems. 
	- Interviewer might provide concerns and restrictions to handle
5. Redesign for the key issues
	- Once you have identified the key issues, its time to adjust your design for it. 
	- be open of any limitatios in your design. your interviewer will problem know know them so communicate it with them



## Algorithm that Scales: Step by Step
You might be asked to just design a single feature or algorithm but in a scalable way

1. Ask Question
	- Interviewer might have intentionally left out some details 
	- Make sure your completely understand the problem 
2. Make Believe
	- Pretend that the data can all fit on one machine and there are no memory limitations. 
	- Answer the question to get a general outline for the solution
3. Get Real 
	- Go back to the orginal problem 
	- Common problems: figure out how to logically divide the data up and how one machine would identify where to look up a different piece of data
4. Solve Problems
	- Solve the issue you identified. 
	- You might have to remove (replace) the issue but try to modify it to fix it. Companies don't like to reinvent something they spend alot of time and money doing. 
	- try to pole holes in your own solutions... shows you understand it. 
	- This is a interative approach, new problems might appear once you solve one. 

## Key Concepts 
There are deep and complex concepts... use online sources 

### Horizontal Vs Vertical Scaling 
	- Vertical scaling means increasing the resources of a specific node. (add addition memory to a server to improve ability to handle load changes)
	- Horizontal scaling means increasing the number of nodes. (add additional servers, thus decreasing the load on any one server)
	- Vertical Scaling is gernally easier than horizontal scaling, but its limited. You can only add so much memory or disk space. 

### Database Denormalization and NoSQL
	- Rational databases such as SQL don't scale well. can get very slow as the system grows bigger. 
	- Can solve the problem by using denormalization or NoSQL
		- Denormalization is adding redundant information into a database to speed up reads (Avoid joins). Instaed of joining to tables, you can just add the info to other tables. 
		- NoSQL Database does not support joins and might structure data differently. It is designed to scale better

### Database Partitioning (Sharding)
	- Sharding means splitting the data across multiple machines while ensuring you have a way to figure out which data is on which machine 
	- a few common ways of partitioning: 
	
	1. Vertical Partitioning : Splitting based on features (columns). Drawback is if one database is large then have to repartition it with differnt method
	
	2. Key-Based (Hash-Based) Partitioning: Allocate N servers and put the data on mod(key, n) based on the ID of the data. Drawback is the number of servers you have is effectively fixed. Adding new servers will cause re-allocations 
	
	3. Directory-Based Partitioning: maintain a lookup table for where the data can be found. Mkaes it relatively easy to add addition servers, but it comes with two drawbacks of lookup table being a single point of failure and constantly accessing this table will cause performance issues. 

### Cashing 
	- For rapid access of results. 
	- Simple key value pairing and typocally sits between your appl layer and your data store.

### Asynchronous Processing and Queues
	- Slow operations should ideally be done asynchronously 
	- can do pre-process so the user doesn't have to wait 

### Networking Metrics
Important metrics around networking:
1. Bandwidth: max amount of data that can be trasnferred in a unit of time. (expressed in bits per second) 
2. Throughput: amount of data that is transferred in general
3. Latency: How long it takes data to go from one end to the other. delay between the sender sending info and the receiver receiving it. 

### MapReduce!!!! ******
	- MapReduce is often associated with Google. 
	- A MapReduce program is typically used to process large amounts of data. 
	- Two steps: Map step and Reduce step
	1. Map: Takes in some data and emits <key, value> pair
	2. Reduce: Takes a key and a set of assoicated values and "reduces" them in some way, emitting a new key and value. The results of this might be fed back into the Reduce for more reducing. 

	- MapReduce allows us to do a lot of processing in parallel, which make processing huge amounts of data more scalable. 
	- More info on page 642!!!


## Considerations (Things to consider about desing)
1. Failures - have a plan for when one or more components fail
2. Availablity and Reliability - Availability is a function of percentage of time the systems is operational. Relaiability is a function of the probability that the system us operational for a certain unit of time. 
3. Read-heavy vs write-heavy - will the app do more reads or writes impacts the design. If write heavy = consider queuing up the writes. If read heavy = consider having a cache. 
4. Security 
















