
### Hello Everyone. Good Evening!!!! This is Vasu from Kingfishers :)

 So Today we are going to have a Knowledge sharing session on new features of Java8. Its a bit long session, so please bear with me. Hope you will have fun :(

#Java8

Before going into more details about Java8. so let's talk about for a while what is `Functional Programming` ?  

  `In computer science, functional programming is a programming paradigm—a style of building the structure
  and elements of computer programs—that treats computation as the evaluation of mathematical functions 
  and avoids changing-state and mutable data.` 
  `It is a declarative programming paradigm, which means 
  programming is done with expressions[1] or declarations[2] instead of statements. In functional code,              
  the output value of a function depends only on the arguments that are input to the function, so calling 
  a function f twice with the same value for an argument x will produce the same result f(x) each time. 
  Eliminating side effects, i.e. changes in state that do not depend on the function inputs, can make it 
  much easier to understand and predict the behavior of a program, which is one of the key motivations for
  the development of functional programming.` -- `Wikipedia`
  
###Thanks to WikiPedia !!!!
Hey!!! but i got little from above giant text: 

  OOP is great!!! amazing though. But the problem is with the mutability.but that's not a problem.
  
  `what about a shared mutability - It's a devils work -- venkat subramaniam`
  
      
###whats the problem with the mutability ? 
* Error prone - Mutable objects are error prone, ex- if you change the input parameters of a function.
* Hard to Reason - Its very hard to explain to my friend, i need a pen and a paper to start drawing some boxes and lines :(
* Hard to make concurrent - Everything will be fine in single threaded application, but monster comes in when it becomes multi threading, in functional programming order of the functions doesn't matter much, This makes concurrent programming much easier, Its ideal for handling complex queries and thousands of millions of calculations.
* Functional Programming does't have side effects.


###Whats so intersting in Functional programming ?
* Immutable state 
* We can pass functions to functions - functions are first class functions 
* Functions has no side effect - it doesn't effect from outside (pure function), No matter how many times you call will get the same value 
* Referntial transparency - If functions are impure then it is tough for the compiler to optimize because to run the functions concurrently, leads to problems. Because changing the order of the functions will results a undesirable results
* Its more expressive - Declarative way - I want to read code as a story . Not like a puzzle - Venkat subrmaniam


###Lambda: 
A lambda is a lines of code which can be passed around to execute.While going to lambda's lets talk about Functional Interfaces, then come back to Lambda's.
Lambda's can be used to represent Functional Interface!!!

###Functional Interfaces (SAM): (Single Abstract Method interfaces)
A Functional Interface is an interface which is annotated as `FunctonalInterface` but its optional, but if we write it then we can't add more than one abstract method but with defaults and static methods 
Note: Static methods cannot be overrided, even though you declared in interface.



