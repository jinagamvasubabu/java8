
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

###is lambda's an Object ?
hmmm.. its little complicated to answer. but no , ask me why ? but for jvm its very easy to work with lambda's because everytime no need to create a new instance and it is a performance boon though. But i can say lambda is an object without identity :)
###Functional Interfaces (SAM): (Single Abstract Method interfaces)
A Functional Interface is an interface which is annotated as `FunctonalInterface` but its optional, but if we write it then we can't add more than one abstract method but with defaults and static methods 
Note: Static methods cannot be overrided, even though you declared in interface.

###Anonymous classes:
An Anonymous class is a local class with out a name. One of the most elegant things about anonymous classes is that they allow you to define a one-shot class exactly where it is needed. In addition, anonymous classes have a succinct syntax that reduces clutter in your code.
Ex: Comparator,Runnable etc

###Functional Interfaces toolbox:
its a new package java.util.function with a rich set of functional interfaces Divided into four categories
* supplier/BiSupplier - It has get function to always supply
* Consumer/BiConsumer - accept SAM. Sysout is a perfect example. Bi means takes two arguments
* Predicate - returns boolean . it has test function
* Function/Bifunction - Function takes an object as a prameter returns as objects as parameter, returns object Bi - accepts two types

###Method References: 
I can say its the simplest way to write lambda's.

###forEach loop:
We have a forEach loop which is newely introduced in Java 1.8

###Predicates:
perdicate is from the functional interfaces toolbox and it is used with fiters


##Streams:
Technical answer is typed interface. It gives way to effeciently process large data or smaller ones.Streams doesn't hold any data.

###Effeciently?
In Parallel, to leaverage the computing power of multicore cpu's. Pipelined, to avoid unnecessary intermediatary computations.

###Filter: used with streams to filter out the result, predicates here is much better to use.

###Reduction:
More kind of aggregate functions in SQL like min,max,sum etc.Reductions don't return any streams and they are terminal operations.

The identity element is both the initial value of the reduction and the default result if there are no elements in the stream.


###lets take an example of map filter reduce !!!

###FlatMap: 
A flatmapper takes two arguments one is element of Type T and returns an element of type Stream. Thus the stream of streams is flattened and become Flatmap



#Java Date time API:
###Instant:
Instant is a point on the time line
* 0 is janauary 1st 1970 at midnight GMT
* Instant.Min 1 billion years ago
* Instant.Max is Dec 31 of the year 1,000,000,000 //1  billion years
* Instant.now is the current instant
* A instant object is mutable. no need to use defensive copy  for to protect it.

###Duration: Duration is the amount of time between two instant
  Instant start = Instant.now();
		
  		for(Long i = 0L; i <1000000000L;){
  			i++;
  		}
		
		Instant end = Instant.now();
		
		Duration d = Duration.between(start, end);
		System.out.println(d.getSeconds());
		
###Many cases were not covered: 
using Instant we cannot create a particular date. for example i can not create birthdate 22-jun-1989

so we need a Date replacer, yes. we need. It is called as LocalDate

###LocalDate:
LocalDate is same like as Date and period is like Duration but it is like duration between two localdates
  		LocalDate dob = LocalDate.of(1989, Month.JUNE, 22); // clear month representations
		
		//period
		Period years = dob.until(LocalDate.now());
		System.out.println("Vasu is:"+years.getYears()+" years old!!!");
		
		long months = dob.until(LocalDate.now(),ChronoUnit.MONTHS);
		System.out.println("Vasu is:"+months+"months old!!!");`
		
		`//to check clearly in years,months,days
		
		Period p1 = Period.between(dob, LocalDate.now());
		System.out.println("Vasu is"+p1.get(ChronoUnit.YEARS)+" years and "+p1.get(ChronoUnit.MONTHS)
		+" months,"+p1.get(ChronoUnit.DAYS)+" Days old");
		
###DateAdjusters:
It is used to add or subtract an amount of time to an instant or LocalDate
		LocalDate now = LocalDate.now();
		LocalDate nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println("Next sunday is on:"+nextSunday);
		
		
		LocalDate firstSundayInMonth = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
		System.out.println(firstSundayInMonth);
		
##Localtime: it is a time of day
		LocalTime l = LocalTime.of(23,53);
		LocalTime l2 = l.plusHours(7);
		
		System.out.println(l2);
		
#ZonedTime: 

		ZonedDateTime IndiaMeeting = ZonedDateTime.of(
									LocalDate.of(2016, Month.APRIL, 29),
									LocalTime.of(15, 30),
									ZoneId.of("Asia/Kolkata"));
		
		ZonedDateTime UkMeeting = IndiaMeeting.withZoneSameInstant(ZoneId.of("Europe/London"));
		System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(IndiaMeeting));
		System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(UkMeeting));
		
#How to format a Date:
After seeing the date from the earlier program. i thought of formatting the dates. Java8 
The new date API proposes a new formatter: DateTimeFormatter, it proposes a set of predefined formatters, available as constants.
DateTimeFormatter will be used in this case.

##Nashorn JS Engine:
Module outline : REPL: Java in JS
Script Engine: Java in JS


* REPL = READ,EVALUATE,PRINT,LOOP
* It looks like a shell, ie with a prompt
* And enables one to type in JS interactively
* jjs is the REPL executable (located in $JAVA_HOME/bin)
* one create Java objects and interact with them. 
`var s = new java.lang.String("HELLO")`
* you can apply any of your String functions like toUpperCase(),toUpperCase(),toString()

###remeber in MAC OS jjs doesn't work directly. it is called as jrunsript. u can put alias as jjs add it to profile. if you are familiar with jjs only.

##Running Javascript in Java application:
* its not new, it was there from java6.
* Many Languages are available called as groovy or JRuby
* To Execute one needs a ScriptEngine by its name


##We can run linux commands using Nashorn shell
[Stackoverlow answer](http://stackoverflow.com/questions/36403242/java-linux-shell-application)
