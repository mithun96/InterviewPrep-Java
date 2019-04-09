# Java OOP Questions?

## Java Overview
Java is a general-purpose computer-programming language that is concurrent, class-based, object-oriented,and specifically designed to have as few implementation dependencies as possible. It is intended to let application developers "write once, run anywhere" (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation. Java applications are typically compiled to "bytecode" that can run on any Java virtual machine (JVM) regardless of the underlying computer architecture. 

## Java - Garbage Collection 
Java uses an automatic garbage collector to manage memory in the object lifecycle. The programmer determines when objects are created, and the Java runtime is responsible for recovering the memory once objects are no longer in use. Once no references to an object remain, the unreachable memory becomes eligible to be freed automatically by the garbage collector.

## Is Java Pure OOP?
No, there are things that can be done without objects. 
Ex. Static Methods

## Method Overloading
When there are multople function in the same class with the same name but with different functionalites (Different # or type of arguments, changing return type does not work)

## Method Overriding 
When methods of the same signiture are in both super and sub class. There method that is chosen is dependent on the object called by at run time. 

## Method Overriding Rules
1. Methods have to be in different class 
2. Have to have the same function signiture 
3. *** Private, Static, Final methods can NOT be overrided. ***
4. Overriding methods can NOT resuce access to method (public method to protected method ==> can not be done)
5. Overriding method can NOT throw higher exception 
	Ex. if super class throws IOException then subclass (overriding method) can not throw Exception 

## Method Overloading Vs. Overrding 
Method overloading is resolved at complie time. Complier only need information of class for method overloading 
Method overriding is resolved at run time. Needs information of obeject to resolve the overriding method 

# Detailed Question

## Static Method
A static method does not need an instance of a class to be called. It belongs to a class and can be called with out an object. 

## Overloading Static Method
Yes, you can overload a static method. You can overload as many static method as you want as long as the parameters are different.

## Overriding Static Method ***
No, you cannot override a static method its not bounded to an object. But you can declare the same static method in its subclass and it will result in method hiding. 

## Can we override a non-static method as static in Java? (answer)
Yes, you can override the non-static method in Java, no problem on them but it should not be private or final :)
Read more: http://www.java67.com/2015/12/top-30-oops-concept-interview-questions-answers-java.html#ixzz50u1h6Q9n

## Private Methods
Private method can only be accessibled in the class it is declared.

## Can you override a private method?  ***
No, you can NOT beucase private method can only be accessibled in the class it is declared. However, you can override a private method in a inner class (nested class) but it does not fundamentally work like method overriding. This is because even if you call the overriden method with the inner class object, the super method will be called. 
Read more: http://java67.blogspot.sg/2013/08/can-we-override-private-method-in-java-inner-class.html

## How do you call superclass version of an overriding method in sub class? (answer)
You can call a superclass version of an overriding method in the subclass by using super keyword. 
Ex. to call the toString() method from java.lang.Object class you can call super.toString().

## Final Method?
Final keyword with the method is to prevent method overriding. You use final when you don't want subclass changing the logic of your method by overriding it due to security reason. 
Ex. String class is final in Java

## Final Class
Final class can not extended. 

## Overriding final methods
No, you cannot override a final method in java. See answer above for reason^

## Abstract Class
Abstract classes are classes that contain zero or more abstract methods. Abstract classes may not be instantiated and require subclasses to provide implementations for the abstract method. They are a class which is incomplete and provide default behavour and ensure that subclass of that class should customize abstract methods. 
Ex. http://www.javacoffeebreak.com/faq/faq0084.html

## Abstract Method
An abstract method is a method that is declared, but contains no implementation. 

## Interface 
Similar to an abstract class, the interface is also there to specify the contract/ functions (abstract methods). It supports OOP abstraction concepts as it defines abstract behaviours. The real use of the interface to define types to leverage Polymorphism. 

## Abstract Class vs Interface
Abstract class can contain non-abstract methods but interface can only contain abstract methods. 
A class can not extend one class but can implement multiple interfaces. 


## Can we have a non-abstract method inside interface? ***
From Java 8 onward you can have a non-abstract method inside interface, prior to that it was not allowed as all method was implicitly public abstract. From JDK 8, you can add static and default method inside an interface.
Read more: http://www.java67.com/2015/12/top-30-oops-concept-interview-questions-answers-java.html#ixzz50u4MRnJ1

## Can we make a class both final and abstract at the same time? 
No, you cannot apply both final and abstract keyword at the class same time because they are exactly opposite of each other. A final class in Java cannot be extended and you cannot use an abstract class without extending and make it a concrete class.

## Polymorphism
Overloading = Compile Time Polymorphism (Static)

Overriding = Run Time Polymorphism (Dynamic)

## Abstraction vs Polymorphism
Abstraction is implemented using abstract class and interface while Polymorphism is supported by overloading and overriding

Abstraction allows programmer to design software better by thinking in general terms while Polymorphism allows programmers to defer choosing the code you want to execute at runtime. 


## Encapsulation 
The practice of keeping fields within a class private, then providing access to them via public methods. 

public methods and data can be accessed by at outside classes.

protected methods and data can be accesseed by any subclass and its own class.

private methods and data can only be accessed by its own class. 

## Inheritance
Allows programmers to create new classes that share some of the attributres of exisiting classes. Allows to reuse work without reinventing the wheel. 


# Cracking the Code Questions? 

## 1. In terms of inheritance, what is teh effect of keeping a constuctor private? 

Declaring a constructor pricate on class A means that you can only access the (private) constructor if you could also access A's private methods. A's inner classes can access it. Additionally, if A is an inncer class of Q, then Q's inner classes can access it too. 

This is directly implication for inheritance because a subclass calls its parents construcutor. The class A can be inherited but only by its own or its parents's inner class. 

## 2. In Java, Does the finally block get executed if we insert a return statement inside the try block of a try-catch-finally? 

Yes, it will get executed. The finally block gets executed when the try block exits. Even when we attempt to exit within the try block (via a return statement, continue, break, exception), the finally block will still be executed. 

Note, there are some cases where the finally block will not get executed, such as following: 
1. if the cirtual machine exits during try/catch block excution 
2. if the thread which is executing during the try/catch block gets killed. 

## 3. What is the difference between final, finally and finalize? 

#### Final
final is ised conrtol whether a variable method or class is changeable. 

final variable can not be changed
final function can not be overridden 
final class can not be subclassed

#### finally
Finally keyword is used in a try/catch block to ensure that a segment of code is always execited

the finally block is often used to write the clean up code. It will be executed after the try and catch block but before control transfers back to its origin. 

#### finalize() 
finalize() method is called by the garbage collector once it determines that no more reference exists. 

The automatic garbage collector calls the finalize() method just before actaully destroying the object. A class can therefore override the finalize() method from the Object class in order to define custom behavior during garbage collection. 

```
protected void finalize() throws Throwable {
	/* Close open files, relaease resources, etc... */
}
```

## 4. ******* Explain the diference between templates in C++ and generics in Java? 
(Read page 435-436 Cracking Code)

Althrough generics and templates look the same in many ways, they are very different. There doing the same thing. In both languages they lets you do something like: ``` List<String> ```. But they difference in how and why they do it. 

In java, the implementation of generics is rooted in an idea of "type erasure". This technique eliminates the parameterized types when source code is translated to the Java Virtual Machine (JVM) byte code. 

```
Vector<String> vector new Vector<String>();
vector.add(new String("hello"));
String str = vector.get(0);

// =======under the hood this will happen at compile time =======

Vectorvector new Vector();
vector.add(new String("hello"));
String str = (String) vector.get(0);

```

In java, static variables are shared across instances of MyClass, regarless of the different type parameters.

the differences: 
1. C++ can use primitive types like int. Java has to use Integer
2. ...
3. ...
4. ...
5. In java, all instance of MyClass, regarfless of the ir type parameters, are the same type. The type parameters are erased at runtime. In C++, instances with different types parameters are different types. 


## 5. reeMap vs. HashMap vs. LinkedHashMap
### Explain the differences between TreeMap, HashMap and LinkedHashMap. Provide an example of when each one would be best? 

HashMap: 
O(1) lookup and insertion 
Keys are not sorted 
implemented by an array of linked lists
used by default unless need some kind of ordering/ sorting. 

TreeMap:
O(logN) loopup and insertion 
Keys are sorted. So can iterate through the keys in sorted order. The keys must implement the Comparable interface 
Implemeted by a Red-Black Tree
Used when you need to get the keys back in their true/natural order. 

LinkedHashMap:
O(1) lookup and insertion 
Keys areordered by their insertion order. 
implemented by doubly linked buckets. 
Used when you need to get the keys back in insertion order. 


## 6. Explain what object reflection is in Java and why it is useful? 
Object reflection is a featuer in Java that provides a way to get reflective information about java classes and objects and perform operations such as:
1. getting info about the methods and feilds present inside the class at RUNTIME 
2. Create new instantce of a class
3. Getting and setting the obejct fields directly by getting field reference, regardless of what the access modifer is. 

used for the following reasons:
1. It can help you observe or manupulate the runtime behavior of apllication 
2. IT can help you debug or test programs as you have direct access to methods, construcutors and fields. 
3. You can call methods by name when you don't know the method in advance. For example, we may let the user pass in a class name, paraamters for the constructor and a method name. We can then use this info to create an object and call a method. Doing these operation without reflection would require a complex series of it statements. 

## 7. Lambda Expression 
Learned it in ECS 160 but have to relearn it!



## 8. What is method hiding in Java? (answer)
When you declare two static methods with same name and signature in both superclass and subclass then they hide each other i.e. a call to the method in the subclass will call the static method declared in that class and a call to the same method is superclass is resolved to the static method declared in the super class.








