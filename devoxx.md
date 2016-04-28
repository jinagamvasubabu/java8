### Lambda's are really cute. please keep in that way - venkat subramaniam
but Why ?
* Its noisy
* Very hard to read
* Code is not reusable, please seperate to a function and use it.

###Iterators:
External Iterators: i was writing this from 5 years. 
` for(int i=0; i< numbers.size();i++){`
    `sysout(i); // please bear with me.. i am Lazy :(`
`}`

###using lambda's:
`numbers.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		});`
It can be simply written as:
`numbers.forEach((i) -> sysout(i));`
more simple way, no need to put brackets for one parameter
`numbers.forEach(i -> sysout(i));`
more simple way, its list of numbers why do we need to create a temporary variable
`numbers.forEach(System.out::println);` //method reference

