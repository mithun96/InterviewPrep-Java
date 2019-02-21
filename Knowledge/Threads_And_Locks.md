
## Threads (in Java)
	- Every thread in java is created and controlled by a unique object of the Java.lang.Thread class.
	- When a standalone application is run, a user thread is automatically created to execute main() method => main thread. 
	- How to implement:
	1. By implementing the java.lang.Runnable interface
	2. By extending the Java.lang.Thread class

## Synchronization
	- Threads within a given process share the same memory space, which is both a postive and negative. 
	- It enables threads to share data which can be valuable. 
	- However, it also creates the opportunity for ussues when two threads modify a resource at the same time. 
	- Java provides synchronization in order to control access to shared resoures. 
	- Using the 'synchronized' keyword, we can restrict access to shared resources to only one thread. 

## Locks
	- For more granular control, we can use locks. 
	- A lock (or monitor) us used to synchronize access to a shared resource by associating the resource with the lock. 
	- A thread gets access to a shared resource by first acquiring the lock associated with the resource. 
	- At any given time, at most one thread can hold the lock and therefore, only one thread can acess the shared resource
	- Common use case: when a resource is accessed from multiple places, but should be only accessed by one thread at a time. 


## Deadlocks and Deadlock Preventions
	- A deadlock is a sitution where a thread is waiting for an object lock that another thread holds and this second thread is waiting for an object lock that the first thread holds. 
	- In order of deadlock to occur, all for of the following conditions have to be met:
	1. Mutual Exclusion: Only one process can access a resource at a given time 
	2. Hold and Wait: Process already holding a resource can request addition resources without giving up current lock
	3. No Preemption: One process cannot forcibly remove another process resources
	4. Circular Wait: Two or more processes form a circular chain where each process is waiting for another resource in the chain. (EASIEST TO REMOVE!!!)


Q: What is the different between a process and a thread?
A:
	A process can be thought of as an instance of a program in execution. It is indpendent entitiy to which system resources. are allocated. Each process is executed in a separate address space. One process can not access the variables and data strucutre of another process. 

	A thread exists within a process and shares the process's resources. Multiple threads within the same process will share the same heap space. Each thread still has its own registers and its own stack but other threads can read and write the heap mempry. 

	A thread is particular execution path of a process. When one thread modifies a process resource, the the change is immediately visible to sibling threads. 



