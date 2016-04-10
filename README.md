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
@FunctionalInterface annotation is optional. but compiler will give me an error if the interface is not functional but annotated as functional.

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







