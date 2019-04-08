// Java program to implement Queue using  
// two stacks with costly enQueue()  
import java.util.*; 
  

/*
Method 1 (By making enQueue operation costly) This method makes sure that oldest entered 
element is always at the top of stack 1, so that deQueue operation just pops from stack1. 
To put the element at top of stack1, stack2 is used.
*/
class GFG  {  
    static class Queue  
    {  
        static Stack<Integer> s1 = new Stack<Integer>();  
        static Stack<Integer> s2 = new Stack<Integer>();  
      
        static void enQueue(int x)  
        {  
            // Move all elements from s1 to s2  
            while (!s1.isEmpty()) 
            {  
                s2.push(s1.pop());  
                //s1.pop();  
            }  
      
            // Push item into s1  
            s1.push(x);  
      
            // Push everything back to s1  
            while (!s2.isEmpty())  
            {  
                s1.push(s2.pop());  
                //s2.pop();  
            }  
        }  
      
        // Dequeue an item from the queue  
        static int deQueue()  
        {  
            // if first stack is empty  
            if (s1.isEmpty())  
            {  
                System.out.println("Q is Empty");  
                System.exit(0);  
            }  
      
            // Return top of s1  
            int x = s1.peek();  
            s1.pop();  
            return x;  
        }  
    };  
  
    // Driver code  
    public static void main(String[] args)  
    {   
        Queue q = new Queue();  
        q.enQueue(1);  
        q.enQueue(2);  
        q.enQueue(3);  
      
        System.out.println(q.deQueue());  
        System.out.println(q.deQueue()); 
        System.out.println(q.deQueue()); 
    }  
}  

/*
Method 2 (By making deQueue operation costly)In this method, in en-queue operation, the new 
element is entered at the top of stack1. In de-queue operation, if stack2 is empty then all 
the elements are moved to stack2 and finally top of stack2 is returned.
*/
public class GFG2 { 
    /* class of queue having two stacks */
    static class Queue { 
        Stack<Integer> stack1; 
        Stack<Integer> stack2; 
    } 
  
    /* Function to push an item to stack*/
    static void push(Stack<Integer> top_ref, int new_data) 
    { 
        // Push the data onto the stack 
        top_ref.push(new_data); 
    } 
  
    /* Function to pop an item from stack*/
    static int pop(Stack<Integer> top_ref) 
    { 
        /*If stack is empty then error */
        if (top_ref.isEmpty()) { 
            System.out.println("Stack Underflow"); 
            System.exit(0); 
        } 
  
        // pop the data from the stack 
        return top_ref.pop(); 
    } 
  
    // Function to enqueue an item to the queue 
    static void enQueue(Queue q, int x) 
    { 
        push(q.stack1, x); 
    } 
  
    /* Function to deQueue an item from queue */
    static int deQueue(Queue q) 
    { 
        int x; 
  
        /* If both stacks are empty then error */
        if (q.stack1.isEmpty() && q.stack2.isEmpty()) { 
            System.out.println("Q is empty"); 
            System.exit(0); 
        } 
  
        /* Move elements from stack1 to stack 2 only if 
        stack2 is empty */
        if (q.stack2.isEmpty()) { 
            while (!q.stack1.isEmpty()) { 
                x = pop(q.stack1); 
                push(q.stack2, x); 
            } 
        } 
        x = pop(q.stack2); 
        return x; 
    } 
}


