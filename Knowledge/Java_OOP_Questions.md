# Java OOP Questions?

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
Method overloading is resolved at complie time. Complier only need information of class for mehtod overloading 
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
No, you cannot override a fianl method in java. See answer above for reason^

## Abstract Class
Abstract classes are classes that contain zero or more abstract methods. Abstract classes may not be instantiated and require subclasses to provide implementations for the abstract method. They are a class which is incomplete and provide default behavour and ensure that subclass of that class should customize abstract methods. 
Ex. http://www.javacoffeebreak.com/faq/faq0084.html

## Abstract Method
An abstract method is a method that is declared, but contains no implementation. 

## Interface 
Similar to an abstract class, the interface is also there to specify the contract/ functions (abstract methods). It supports OOP abstraction concepts as it defines abstract behaviours. The real use of the interface to define types to leverage Polymorphism. 

## Abstract Class vs Interface
Abstract class can contain non-abstract methods but interface can not contain abstract methods. 
A class can not extend one class but can implement multiple interfaces. 


## Can we have a non-abstract method inside interface? (answer)
From Java 8 onward you can have a non-abstract method inside interface, prior to that it was not allowed as all method was implicitly public abstract. From JDK 8, you can add static and default method inside an interface.
Read more: http://www.java67.com/2015/12/top-30-oops-concept-interview-questions-answers-java.html#ixzz50u4MRnJ1

## Can we make a class both final and abstract at the same time? (answer)
No, you cannot apply both final and abstract keyword at the class same time because they are exactly opposite of each other. A final class in Java cannot be extended and you cannot use an abstract class without extending and make it a concrete class.

## Polymorphism
Overloading = Compile Time Polymorphism (Static)
Overriding = Run Time Polymorphism (Dynamic)

## Abstraction vs Polymorphism
Abstraction is implemented using abstract class and interface while Polymorphism is supported by iverloading and overriding
Abstraction allows programmer to design sofrware better by thinking in general terms while Polymorphism allows programmers to defer choosing the code you want to execute at runtime. 


## Encapsulation 
the practice of keeping fields within a class private, then providing access to them via public methods. 
public methods and data can be accessed by at outside classes.
protected methods and data can be accesseed by any subclass and its own class.
private methods and data can only be accessed by its own class. 

## Inheritance
Allows programmers to create new classes that share some of the attributres of exisiting classes. Allows to reuse work without reinventing the wheel. 





















