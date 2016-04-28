# java8
#Lambda ?
Answer is to make instances of Anonymous classes which is easier to write and read :)
only functional interface can do this.

#what is the type of lambda's?
Answer is functional interface.

#can i put lambda in a variable ? because methods can override the lambda's
yes

#is lambda's an Object ?
hmmm.. its little complicated to answer. but no , ask me why ? but for jvm its very easy to work with lambda's because everytime no need to create a new instance and it is a performance boon though.
But i can say lambda is an object without identity :)

#Functional Interface ?
It is an interface with only one abstract method
eg: Comparator, Runnable, FileFilter
@FunctionalInterface annotation is optional. but compiler will give me an error if the interface is not functional if annotated as functional.

#Functional Interfaces toolbox
New package : java.util.function
with a rich set of functional interfaces
Divided into four categories 
1.supplier/BiSupplier
2.Consumer/BiConsumer
3.Predicate - returns boolean
4.Function/Bifunction - returns object
Bi - accepts two types


#Method References ?
These are the much more simplest way to write lambda's. ask me how ?
`    Comparator<Integer> simpleLambda = Integer::compare;
     List<Integer> intList = Arrays.asList(1,42,2,190);
		 Collections.sort(intList,simpleLambda);`
				

#How can we process our data using these tools?
`   List<Customer> cList = Arrays.asList(new Customer(1,"vasu"),new Customer(2,"santhosh"));
		cList.forEach(customer -> System.out.println(customer));
		//much more simpler 
		cList.forEach(System.out::println);`

#if you observe the above code, we are using forEach but where is it implemented ?
Answer is iterable, but make sure it will break when you run in lesser versions of java, because it is added in 1.8 :P


#Default Methods?
Modify the existing interface with out breaking the functonality.static methods are also allowed in java8 interfaces

#New Patterns
Eg: predicate
`Predicate<String> p1 = s -> s.length() > 4;
		Predicate<String> p2 = s -> s.length() > 7;
		Predicate<String> p3 = p1.and(p2);
		
		//dig in and method of predicate its a default method
		System.out.println(p3.test(s1));`

`List<String> items = Arrays.asList("vasu","santhosh","srinu","prasanna","nataraj");
		List<String> result = new ArrayList<>();
		
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = result::add;
		
		items.forEach(c1.andThen(c2));
		System.out.println("result is :"+ result.size());`

#Streams and collectors:

#Map/Filter/Reduce: For suppose in a list of persons, we want average of people whose age is more than 20.
Map: Map the list of Persons to List of Integers
Filter: it will returns the list<Integer> after filtering out the condition 20 using predicates.
Reduce: it is more like SQl aggregate functions.

let's take an example:
`//First scenario :
		// I want persons average whose age is more than 20
		List<Person> pList = Arrays.asList(new Person(26, "vasu"),new Person(30,"natraj"),new Person(26,"santhosh"),new Person(25,"srinu"));
		
		
		//pList.parallelStream()
		List<Person> updatedList = pList.stream().
				filter(c -> c.getAge() > 25).
				/*map(new Function<Person,Person>(){

					@Override
					public Person apply(Person t) {
						return new Person(t);
					}
					
				});*/
				//map(p -> new Person(p));
				map(Person::new).
				//collect(Collectors.toList());
				collect(Collectors.toCollection(ArrayList::new));`

#Streams: 
Technical answer is typed interface.
It gives way to effeciently process large data or smaller ones.Streams doesn't hold any data.

##u may ask what is effeciently?
hmmm.. that's a good question. here it is :
In Parallel, to leaverage the computing power of multicore cpu's.
Pipelined, to avoid unnecessary intermediatary computations.

#Filter: 
used with streams to filter out the result, predicates here is much better to use.
`List<String> cList = Arrays.asList("one","two","three","four","five");
		Predicate<String> p1 = p -> p.length() > 2; 
		Predicate<String> p2 = Predicate.isEqual("two");
		cList.stream().
				filter(p1.and(p2)). //can use or,negate
				forEach(System.out::println);`

				
#stream API:
forEach(Consumer) not Lazy and does not return any stream
Peek(Consumer) lazy and it return the stream 
filter(Predicate) lazy

#Mapping Operation:
A mapper is modeled by function interface. Map returns the stream
<R> Stream<R> map(Function<T, R> mapper);

#FlatMap:
A flatmapper takes two arguments one is element of Type T and returns an element of type Stream<R>
It is a stream of streams.Thus the stream of streams is flattened and become Flatmap

#Reduction:
More kind of aggregate functions in SQL like min,max,sum etc.Reductions don't return any streams and they are terminal operations.

The identity element is both the initial value of the reduction and the default result if there are no elements in the stream.

##Available Reductions:
max, min, Count

##Boolean Reductions:
allMatch, noneMatch and anyMatch


##collectors:
It is another type of reduction and it is called as mutable reduction. why because instead of aggregating elements it will put in a container.

`String persons = pList.stream().
				filter(c->c.getAge() > 20).
				//map(p -> p.getName()).
				map(Person::getName).
				collect(Collectors.joining(","));`

###Collecting in a Map:
For example if we want a map of all aged group persons in list (group by age).
we can do easily by Collectors groupingby

`Map<Integer, List<Person>> pMap = pList.stream().
					filter(p -> p.getAge() > 20).
					collect(Collectors.groupingBy(Person::getAge));`


#Date and Time API:

###why do we need a new Date time API?
Date API till java7: java.util.date and java.sql.date. 
to create a new date object `Date d = new Date(2016,1,1); // 2016+1900
		System.out.println(d.toString());
		
		
		Calendar c = Calendar.getInstance();
		c.set(2016, 00, 10, 0, 0, 0);
		System.out.println(c.getTime());
		
		// add 7 days to c
		c.add(Calendar.DAY_OF_MONTH, 7);
		System.out.println(c.getTime());`
###Datetime api in java7 is mutable: mutable !!!! yes. Date can be modified, but can be restricted with defensive copy!!!

###New API in java8, package is java.time it completley replace the java.util.date and Calendar

###Insant:
Instant is a point on the time line
`0 is janauary 1st 1970 at midnight GMT
Instant.Min 1 billion years ago
Instant.Max is Dec 31 of the year 1,000,000,000 //1  billion years
Instant.now is the current instant
`

A instant object is mutable. no need to use defensive copy  for to protect it.
###Duration: Duration is the amount of time between two instant
`Instant start = Instant.now();
		
		for(Long i = 0L; i <1000000000L;){
			i++;
		}
		
		Instant end = Instant.now();
		
		Duration d = Duration.between(start, end);
		System.out.println(d.getSeconds());`
###Many cases were not covered: 
using Instant we cannot create a particular date. for example i can not create birthdate 22-jun-1989

so we need a Date replacer, yes. we need. It is called as LocalDate

###LocalDate:
LocalDate is same like as Date and period is like Duration but it is the duration between two localdates
`LocalDate dob = LocalDate.of(1989, Month.JUNE, 22); // clear month representations
		
		//period
		Period years = dob.until(LocalDate.now());
		System.out.println("Vasu is:"+years.getYears()+" years old!!!");
		
		long months = dob.until(LocalDate.now(),ChronoUnit.MONTHS);
		System.out.println("Vasu is:"+months+"months old!!!");`
		
		`//to check clearly in years,months,days
		
		Period p1 = Period.between(dob, LocalDate.now());
		System.out.println("Vasu is"+p1.get(ChronoUnit.YEARS)+" years and "+p1.get(ChronoUnit.MONTHS)
		+" months,"+p1.get(ChronoUnit.DAYS)+" Days old");`
###DateAdjusters:
It is used to add or subtract an amount of time to an instant or LocalDate
`LocalDate now = LocalDate.now();
		LocalDate nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println("Next sunday is on:"+nextSunday);`
		
		`
		LocalDate firstSundayInMonth = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
		System.out.println(firstSundayInMonth);`
		
##Localtime: it is a time of day
`	LocalTime l = LocalTime.of(23,53);
		LocalTime l2 = l.plusHours(7);
		
		System.out.println(l2);`
#ZonedTime: 
`
		ZonedDateTime IndiaMeeting = ZonedDateTime.of(
									LocalDate.of(2016, Month.APRIL, 29),
									LocalTime.of(15, 30),
									ZoneId.of("Asia/Kolkata"));
		
		ZonedDateTime UkMeeting = IndiaMeeting.withZoneSameInstant(ZoneId.of("Europe/London"));
		System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(IndiaMeeting));
		System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(UkMeeting));`
		
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








		







		





