

/* Java program to implement basic stack 
operations */
class Stack 
{ 
    static final int MAX = 1000; 
    int top; 
  	ArrayList<Integer> stack; 

    boolean isEmpty() 
    { 
        return (top < 0); 
    } 

    Stack() 
    { 
    	stack = new ArrayList();
        top = -1; 
    } 
  
    boolean push(int x) 
    { 
         
	    a.add(x); 
	    System.out.println(x + " pushed into stack"); 
	    return true; 
        
    } 
  
    int pop() 
    { 
        if (stack.isEmpty()) 
        { 
            System.out.println("Stack Underflow"); 
            return 0; 
        } 
        else
        { 
            return stack.get(stack.length - 1); 
        } 
    } 
} 
  
// Driver code 
class Main 
{ 
    public static void main(String args[]) 
    { 
        Stack s = new Stack(); 
        s.push(10); 
        s.push(20); 
        s.push(30); 
        System.out.println(s.pop() + " Popped from stack"); 
    } 
} 