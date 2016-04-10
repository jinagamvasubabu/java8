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
More kind of aggregate functions in SQL like min,max,sum etc











		





