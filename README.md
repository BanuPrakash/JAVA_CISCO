# JAVA


Banuprakash C

Full Stack Architect, Corporate Trainer

Co-founder & CTO: Lucida Technologies Pvt Ltd., 

Email: 

banuprakashc@yahoo.co.in

banuprakash.cr@gmail.com

banu@lucidatechnologies.com

https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/JAVA_CISCO

===================================

Softwares Required:

1) openJDK 21
https://jdk.java.net/java-se-ri/21

Option 1:
install and add path and JAVA_HOME

vi ~/.zshrc
export JAVA_HOME=/Users/banuprakash/Desktop/jdk-21

export PATH="/Users/banuprakash/Desktop/jdk-21/bin:"$PATH

Option 2: [better]

USE SDKMAN to manage java

curl -s "https://get.sdkman.io" | bash

sdk install java 21.0.6-tem

sdk default java 21.0.6-tem 

https://mydeveloperplanet.com/2022/04/05/how-to-manage-your-jdks-with-sdkman/#:~:text=Some%20time%20ago%2C%20a%20colleague%20of%20mine,maintain%20different%20versions%20of%20JDKs%2C%20Maven%2C%20etc.


2) IntelliJ Ultimate or Community edition https://www.jetbrains.com/idea/download/?section=mac

3) MySQL  [ Prefer on Docker]

Install Docker Desktop

Docker steps:

```
a) docker pull mysql

b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -t -i local-mysql bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit

=======


$ java --version

========================================

OOP with Java.

OOP: Object Oriented Programming / Paradigm

Writing programs which resemble real world.

Tv/ AC / Fan / Bulb / Computer ,,,, are examples of real world objects.

Object: has state and behaviour
State example for TV: on/off, channel, volume, brightness, ... 
Behaviour: Switch On/off, changeChannel, Increase or decrease volume/brightness

Bulb:
State: on/off, brightness
Behaviour: switch on/off

Banking Account is also an object
State: balance
behaviour: credit/debit/check

Once we know what should be the state and behaviour of object we need templates to create them,
In software we use different programming languages to create templates:

```
1) C++ / Java / C# / TypeScript --> class as template

class BankingAccount {
    double balance;

    credit(amt) {}
    debit(amt) {}
}

2) JS --> function as template

function BankingAccount() {
    this.balance;
}

BankingAccount.prototype.credit = function(amt) {}

```
Abstraction:
We use interfaces to send messages to objects. User of object just needs to know what the message/behaviour/action does without worrying about how it does.

SOLID Design Principles has to be followed for good OOP.

S --> Single Resposibility Principle
O --> Open Close Principle
    Closed for Change, open for extention
L -> Liskov Substitution Principle.
At any point of time a specialized object should be able to replace a generaized object and get the work done.
Generalization and Specialization relationship
Account is generalized
SavingsAccount, LoanAccount, CurrentAccount. RDAccount are also specialized accounts

Account:
    login() and logout()

I should be able to login() and logout() using SavingsAccount / LoanAccount ... also

If we add credit() and debit() in account, this fails LSP, Why?
SavingsAccount can credit() and debit() but not with LoanAccount [ fails]

I --> Interface segregation
Banking Service has credit(), debit(), checkBalance(), createAccount(), lockAccount(), seeAllTransactions(), ....

If we login as Customer we get CustomerInterface which gives me only credit(), debit(), checkBalance()

If Admin logs in he gets AdminInterface using which he/she can createAccount(), lockAccount(), seeAllTransactions(), [different Remote]

D --> Dependency Injection
Inversion of Control

Flow:
Application ==> Presentation ==> Business Logic ==> Data Access Object ===> database

Normally we create Presentation object in Application, ... establish database connection in DAO layer
class Presentation {
    BusinessLogic logic = new BusinessLogic();
}

class DAO {
    Connection con = new Connection();
}

With DI, the flow is reveresed
Application <== Presentation <= Business Logic <== Data Access Object <=== database

=======

What is Java?
Java is a technology. It provides a platform which has JRE [Java Runtime environment] to execute bytecode.

What is bytecode? Compiled code like obj of C language.

How to generate a bytecode?
we need Development kits for that.
1) JDK --> Java Development kit which uses Java as programming language
JDK provides compiler to convert java code to bytecode
2) KDK --> kotlin development kit which use Kotlin as programming language
KDK provides compiler to covert kotlin to bytecode
3) Groovy ...

===========================================================
Data types:
Integeral types
byte -- 1 byte
short -- 2 bytes
int --> 4 bytes 
long --> 8 bytes

float --> 4 bytes
double --> 8 bytes

char --> 2 bytes of UNICODE character set [ ASCII is 1 byte]

boolean --> 1 byte [ true or false]

Java as programming language:

```
Account.java
public class Account {
    private double balance; // state of object

    // behaviour / action / message
    public void deposit(double amt) {
        this.balance += amt;
    }

    // behaviour / action / message
    public double getBalance() {
        return this.balance;
    }
}

```

JDK comes with compiler:
javac Account.java ===> Account.class [ bytecode]

bytecode is platform independent and architecture neutral


```
AccountExample.java

public class AccountExample {
    public static void main(String[] args) {
        Account rahulAcc = new Account();
        Account swethaAcc = new Account();

        rahulAcc.deposit(4000);
        swethaAcc.deposit(5000);

        System.out.println(rahulAcc.getBalance());
    }
}

```

javac AccountExample.java --> AccountExample.class [bytecode]

=============

to start JavaRuntime Environment [JRE]
java AccountExample

set CLASSPATH= .;c:\temp;d:\lib;d:\projects\lib;

new keyword is for dynamic memory allocation, like malloc / calloc of C programming
memory is allocated on HEAP area

tv.on(); here tv is the context
ac.on(); context here AC

context.message(arguments);

tv.changeChannel(454); 
tv.setVolume(45);

deposit(swethaAcc, 5000);

getBalance(rahulAcc);

=================================

Logically grouping of objects/classes in enterprise application
1) entity classes 
they represent business data. data which is long lived, generally survives the application crash. they have storage like database, redis, files, ...

Example for Uber:
Customer, Vehicle, Driver, Trip, Payment,,, 

Example for Amazon:
Customer, Product, Seller, Order, LineItem, Payment, ...

Most of the time these classes contains state, constructors, accessor, mutation code. No business logic inside this

https://www.database-answers.com/data_models/


Example:
```
    public class Customer {
        private String email; // state
        private String password; // state
        private String firstName;  // state
        
        //mutation
        public void setPassword(String pwd) {
            this.password = pwd;
        }
        
        //accessor
        public String getFirstName() {
            retutn this.firstName;
        }
    }

```

2) DAO: Data Access Objects
This contains code for CRUD operations [CREATE READ UPDATE and DELETE operations]

```
    public class CustomerDao {
        public void register(Customer c) {
            INSERT INTO customers table ....
        }

        public boolean login(Customer c) {
            select email and password from database table ...
        }
    }

```

3) Service classes: acts as a facade over DAO and buisness logic
Also decide what needs to be exposed to the client...

```
    public class BankingService {
        // one method call from client
        public void transferFunds(Account fromAcc, Account toAcc, double amt) {
            // check balance in fromAcc
            // business check if customer is eligible to transfer ...
            // update toAcc
            // update fromAcc
            // insert into transaction table
            // send SMS
            // send EMAIL
        }
    }

```

4) Utility classes: helper classes
5) Client classes: Android / Web based / Console based ...
6) Exception classes ...

===============

In java we use packages to logically group classes.
Packages are nothing but a folders

=====

In IDEs build is enabled by default which does the job of "javac"

state / instance variable are created for every object in heap area

visiblity mode:
1) private : visible only for class members
2) public: visible every where, inside the current class as well as classes present in other packages also.
3) default [package private]: [no access modifier specifed] visible to all classes within the same package. Not visible outside of package
4) protected: ...

=============

Constructors:
1) sort of special methods which has same name as that of class
2) no explict return type
3) they are invoked as soon as the object is created.
4) We can't explictly call the constructor
5) constructors can be overloaded [ more than one]
6) main purpose of constructor is used to initialize an object
7) Compiler creates default constructor if we don't write any.
If we write our own constructor then it's our responsibility to provide default also
Call a carpenter and ask him you need a Computer table [ he uses default values --> default constructor]

Give Carpepter the dimensions [ 4x2x3] --> parametrized constructor

Show him existing table and ask him to make a replica --> Copy constructor [ avoid in Java]

==================

static members

We need a member to keep track of how many instance s of Account exist?

static variable: class member, all objects of the given class share the memory [ metaspace]
instance variables: object members, each object will have a member in heap area

static methods: use class to invoke
instance method: use object context to invoke.

Rule: static methods can't access instance variables. 

first argument to instance method is implicit "this", for static methods "this" is not passed.

=========

Relationship between objects:
1) Generalization and Specialization
2) Realization
3) Association [composition or aggregation]
4) Uses A

Java build tools:
1) IDE: IntelliJ / Eclispe / NetBeans / BlueJ / ...
2) Checkstyle: used to check Coding conventions like NamingConventions and Java comments
3) PMD/FindBugs: used to check coding standards like proper conditional statements, empty catch block,
copy & paste code...
4) SONAR: 2 and 3 combined
5) Jenkins: CI/CD pipeline
6) Repository: Git, BitBucket, SVN,...
...

class Object

https://www.youtube.com/watch?v=hXkzfLaps8s

Problem: She said I keep Tv in my Pocket. Tailor 32' pocket
She should have told, I keep Mobile in my pocket which has Tv  App

=================

Understanding Inheritance:

Part 1: Memory is allocated for inherited members also in heap area
```
    class Product {
        private int id;
        private String name;
        private double price;
    }

    public class Mobile extends Product{
        private String connectivity;
    }

    new Mobile(); // check PDF

```

To avoid too much level of Inheritance we use design Pattern - Bridge Pattern, instead of single hererachy, we split hierarchy.

Part 2: Constructor Chaining

```
 class Product {
       public Product() {
        prints P1
       }

         public Product(int id, String name) {
            prints P2
       }

    }

    public class Mobile extends Product{
        public Mobile() {
             prints M1
       }

        public Mobile(int id, String name, String connectivity) {
            super(id, name);
            prints M2
       }
    }

    new Mobile(); // P1, followed by M1
    new Mobile(34, "iPhone 6e", "5G"); // P1, followed by M2
```

Part 3: Method invocation

```
class Product {
        public String getName() {
            return name;
        }
        public double getPrice() {
            return 0;
        }

    }

    public class Mobile extends Product{
        public String getConnectivity() {
            return "3G";
        }
        public double getPrice() { // override
            return 50,000;
        }
    }

    Mobile m = new Mobile(1, "Samsung Fold");
    m.getName(); // valid
    m.getPrice(); // dynamic binding --> 50,000.00
    m.getConnectivity(); // 3G

    Product p = new Mobile(1, "Samsung Fold");
    p.getName(); // valid
    p.getPrice(); // dynamic binding --> 50,000.00
    p.getConnectivity(); // Fails, Product doesn't know about getConnectivity() message

```

Rule:
1) which method gets called is based on what the pointer is pointing to [Right hand side].
2) Remote / reference / left hand side of "=" will decide which methods/messages can be sent

Overriding: base class already contains the behaviour, specialized one overrides the behaviour.

```
instanceof --> family of

Product p = new Mobile();

p instanceof Mobile ==> true
p instanceof Product ==> true
p instanceof Object ===> true
p instanceof Tv ==> false

```
for strict checking use Class Info
getClass()

How do you invoke a method?
1) If we know the method name in advance
context.method(argumets)

2) If we have pointer to a method
m.invoke(context);

Example:
m is pointing to getPrice()
m.invoke(p); --> as good as p.getPrice();

m is pointing to setPrice(amt);
m.invoke(p, 5000);

=======

abstract, realization relationship, data containers, ...

=======


Recap:
OOP, object, state and behaviour, template -- class
SOLID Design principles
What is Java?
Technology. JDK, JRE, classloader, Metaspace, stack, heap area
IntelliJ IDE 
Relationship between objects
Generalization and Specialization --> Inheritance
keywords "extends"

Note:
1) In java every object is inherited from java.lang.Object
2) Single root hierarchy
3) java doesn't support multiple inheritance
class A extends B, C {} // not valid
4) override: base class already has the behaviour, which inherited class inherites and re-defines it.
5) UPCASTING and DOWNCASTING
Before doing Downcasting typechecking has to be done, else there could be ClassCastException.
TypeChecking can be done using:
a) instanceof operator [family of]
b) getClass() method of java.lang.Object [strict checking]
6) Dynamic binding and polymorphism p.isExpensive()
7) methods to implement OCP

Day 2

Why do we upcast?
```
 Product[] products = new Product[5]; // Array of pointers to Product type, not actual Product
    products[0] = new Mobile(52, "iPhone 6", 89000.00, "5G"); //upcasting
    products[1] = new Tv(56, "Onida Thunder", 3200.00, "CRT");//upcasting
    products[2] = new Tv(71, "Sony Bravia 6", 2_32_000.00, "OLED");//upcasting
    products[3] = new Mobile(13, "MotoG", 12000.00, "4G");//upcasting
    products[4] = new Product(511,"Dummy", 0); 

    Helps in OCP:
     for(Product p : products) {
            if(p.isExpensive()) { 
                ...
            }
     }
```

Without upcasting:

```
    Mobile[] mobiles = new Mobile[100];
    Tv[] tvs = new Tv[50];
    DishWasher[] dw = new DishWasher[25];

    for(Mobile m : mobiles) {
        ...
    }
    for(Tv t: tvs) {
        ...
    }

```

=====================
Abstract class:
Few types are meant just for generalization, such a thing doesn't exist in real world.
Example:
1) Product: public abstract class Product {
     products[4] = new Product(511,"Dummy", 0);// fails

2) BankingAccount

We can't instantiate an abstract class.

Abstract methods:
a method can't have any implementation, but we need to enforce it's implmentation in all sub-classes.
public abstract boolean isExpensive();

Note:
1) An abstract class need not have abstract methods
2) If one of the method is marked as abstract, then class has to be declared abstract

===================

Realization Relationship

A realization relationship signifies that one element/component/object (the client) implements or realizes the behavior specified by another element/component/object (the supplier), often an interface.

Purpose:
Realization establishes a contract where the client (the implementing element) promises to fulfill the behavior defined by the supplier (the interface or specification). 

Example interface for a Contract:

```

public interface UserDao {
     void register(User user);
     boolean login(String username, String password);
}

```

By default all the methods in interface are public and abstract.

Why program to interface?
1) DESIGN --> drafting interfaces for User stories is easy
2) IMPLEMENTATION
3) TESTING --> we can mock and test
4) INTEGRATION
5) LOOSE COUPLING

============

"extends" --> Speacialization [IS A]
"implements" --> realization [ contract / protocol / follow the rules ..], does not establish a IS A

Strategy Design Pattern
Switching between strategies:

```

//        MobileDao mobileDao = new MobileDaoDbImpl();
        MobileDao mobileDao = new MobileDaoMongoImpl();

```

There is a problem with above code.
1) Too many clients like Android, swift, Console based , Web application ,...
Every client needs to update the implmentation
2) Why should the developers of client application know about implementation

Solution: Use Factory method [ Factory design Pattern]

Client decides which type is required:

```
    public class PlantFactory {

        public static Plants[] getPlants(String season) {
            case "SUMMER":
                ...
            case "WINTER":
                ...
            case "SPRING":
                ..
        }
    }


    CLient:
    Plants[] = PlantFactory.getPlants("SUMMER");

```

I don't want any code changes, but need to switch between strategies.
Solution: use configuration files like xml / JSON / properties ...

config.properties is a key/value pair
```

MOBILE_DAO=com.cisco.prj.dao.MobileDaoDbImpl

```

load a class programatically:

Class.forName("com.cisco.prg.entity.Mobile"); loads Mobile class into JVM / JRE metaspace

Class.forName("com.cisco.prg.entity.Mobile").getConstructor().newInstance(); // create object

is similar as:
new Mobile();

```
=========================

interfaces as a contract for OCP.

Requirement: Sort objects, not sure as of writing this method what type of objects will be passed.

```

sort(Circle[] circles) {}
sort(Rectangle[] rectangles) {}
sort(String[] names) {}

public interface Comparable {
    public int compareTo(Object o);
}

```

Exception Handling:

Any abnormal condition that arises during program execution is an exception.
these exceptions can be broadly classified as "error type" and "exception type"
Error type of exceptions are once where we can't have solution and alternate flow. Program is bound to crash

Exception type of exceptions are once where we can handle and provide alternate flow/solution.

Examples of Error type of exceptions:
1) StackOverflowError
2) OutOfMemoryError
3) UnsatisfiedLinkError

Exception: is an object which tells
a) What went wrong
b) Why did it go wrong
c) Where did it go wrong

Exception type of exceptions can be classified into:

a) Unchecked type of exception
exceptions for which compiler doesn't enforce you to handle.
these exceptions are a result of problem within JRE
Supposed to be handled with conditional statements.

```
    int x = 10;
    int y = 0;
    if( y != 0) {
      int res = x / y;
    }

```
b) Checked type of exception
exceptions occuring outside of JRE like database, OS, Sockets, ...
Since exceptions has already been created outside of JRE and propagated to your program,
compiler enforces you to handle it
Syntax for handling is :

```

    try {
        // actual code 
    } catch(ExceptionType1 ex) {
        ..
    } catch(ExceptionType2 ex) {
        ...
    } finally {
        // optional
        // here we write code to release resources like DB connection, close of files, sockets
    }

finally block is a compulsary execute code, gets called if exception occurs or not

```

"throws" is to inform the caller that a certain type of exception might occur while executing a method()

More on this in database coding.

====================

Generics:
A generic type is a generic class or interface that is parameterized over types.


```

public class Rectangle {
    private int width;
    private int breadth;
    ...
}

Rectangle r1 = new Rectangle(4,5);


public class DRectangle {
    private double width;
    private double breadth;
    ...
}

DRectangle r2 = new DRectangle(4.2, 1.5);

/**
 * Generic version of the Rectangle class.
 * @param <T> the type of the value being boxed
 */

public class Rectangle <T> {

    private T width;
    private T breadth;

}

Rectangle<Integer> r1 = new Rectangle<Integer>(4,5);
Rectangle<Double> r2 = new Rectangle<Double>(4.2, 1.5);
Rectangle<String> r3 = new Rectangle<String>( "A" , "B");

Rectangle<int> r1 = new Rectangle<int>(4,5); // fails, generics is only for Object type, not for primitive types

```

Integer is a type wrapper for "int"
Double is a type wrapper for "double"
Byte is a type wrapper for "byte"
...

============

Java Collection Framework --> data containers in java

Array is a data container, most prefered container
Problems of array:
1) size is fixed, can't grow nor shrink
User[] users = new User[100];
2) adding  / removing elements in arbitray position is difficult, move other elements up / down
3) needs contiguos memory

Comparable and Comparator interfaces : meant of object comparision
Comparable: this has to be used if the object itself is providing the comparison criteria
Comparator: this is used by the client, to compare based on different criteria

toString() will be called whenever object has to be converted to a String

System.out.println(p); // p is a product


"Arrays" class is a utility / algorithm class which contains methods for sort, max, min, binarySearch, ... which works on Comparable / Comparator contract

===========

Anonymous class:
class without a name.
Objects can be created from anonymous class based on interface / abstract class.
This class info will be used temporarily to create object, class info won't reside in metaspace

```

public class LengthComparator implements Comparator<String> {
public class NameComparator implements Comparator<String> {
public class CategoryComparator implements Comparator<String> {

```
Lambda expressions:
A lambda expression is a short block of code which takes in parameters and returns a value.
lambda expression can be used instead of anonymous class if interface has only one method to implement.

Java Collection Framework:
List, Set, Queue, Map are data containers

```
List:                                        
* ordered collection                                                   
* supports duplicate elements
* can be re-ordered
* supports index based operation like get(5); add(obj, 10); remove(3);

Set:
* ordering is based on algorithm  
* unique
* can't re-order
* doesn't support index based operation

```
Usage of List data container:

Option 1: Avoid this
ArrayList list = new ArrayList();
always program to interface.
Always use generics, else it is not type-safe

```
list.add("a");
list.add(new Product());
list.add(new Account()); 

if(list.get(1) instanceof Product) {
    Product p = (Product) list.get(1);
}

Option 2:
List<Product> list = new ArrayList<Product>();
list.add("a"); // fails
list.add(new Product());
no need to type-check
Product p = list.get(1);

```

Collections contain algorithms like sort, max, binarySearch similar to Arrays but can be used on List type of data-container.

Java version 8 introduced streams.
Stream API is used to process collections of objects. A stream in Java is a sequence of objects that supports various methods [filter, map, reduce, ..] that can be pipelined to produce the desired result. 

https://rxmarbles.com/

Java 8 stream, Set and Map
Annotation
Java Concurrency [ multi-threaded application]

===============================

Recap:

Realization relationship: element/component realizes the behiour specified by other element/component.
Done using interface.

class implements interface.

"extends" is for inheritance,
"implements" is for realization

Note:
1) class can extends from only one class, multiple inheritance is not valid in Java
2) class can realize multiple interfaces
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence,
               Constable, ConstantDesc {}

Generics. 

Java Collection Framework: Comparable [logic is part of object on which comparision is happening], Comparator [logic is in client code]

Arrays contains methods like sort(), max() ,,, which can be used on array type of data container

List type of data container, ArrayList and LinkedList
Collections is similar to Arrays class but can be used only on List type of data container.

Anonymous class can be used from interfaces or abstract class. Go for concrete class only if it has extra state or behaviour.

Lambda expressions can be used instead of anonymous class only if there is one method to implement.

=====================================================

Day 3:

High Order Functions:
1) functions which can accept function as argument
2) functions which can return a function

treat functions as first-class members like primitive / object

Commonly used high order functions are:
1) filter accepts Predicate : this function is to get a sub-set of collection based on predicate
2) map accepts Transform function: this function is use to transform the data
3) reduce accepts aggregate function: sum(), avg(), count(), 
4) forEach accepts a consumer function to consume each element


Intermediary functions: filter, map, skip, limit, ...
Terminal functions: forEach, reduce, collect

We need a terminal function in the chain, else data wont flow.

=======

```

        // can re-order
        Collections.sort(products);
        Collections.reverse(products);
        Collections.shuffle(products);

        // index based operations are supported...
        Product p = products.get(2);
        products.remove(1);

```

Set type of data container:
* unique elements
* not ordered
* can re-order
* Can't use index based operation

HashSet [90%] and TreeSet [ 2-3 %] are commonly used Set type of implementations

HashCode:
1) Numerical value of an object, stored in header part of heap area along with state of object
2) if 2 objects are similar, then their hash codes has to be same
3) if 2 objects has same hash code, it doesn't mean they are similar [ possible ]

hashCode() method is inherited from java.lang.Object, we need to override it for our domain/entity/model classes.

java.lang.Object methods:
1) toString() need to override
2) hashCode() need to override
3) getClass() just use it.
4) equals() need to override

Object equality
equals() vs  == operator

== operator is to check if both objects are same, pointing to same address in memory
equals() is to check if objects contain same state.

================


HashSet uses hashCode() and equals() method for duplicate identification and deciding the order of where the object has to be inserted in data container.

Default LoadFactory is 75%; if 75 % of buckets are filled, capacity doubles and re-hashing happens

inital capacity = 16 --> 32 --> 64 --> 128

====

TreeSet uses Comparable or Comparator to identify duplicates and deciding on the order of insertion.

Avoid using TreeSet if there is lot of mutation. IT is a Red-Black Tree implementation. 
can be used only if one time data is inserted and read many operations.

Best way to use is :
1) use HashSet while adding
2) while giving the data to client use List, so that client can re-order based on different fields.


record is an immutable object,
it  comes with constructor, getters, toString, hashCode(), equals()

Generally we use this as data carriers.
Many a times when we join tables fields from different entity has to be combined and given

// order_date from orders table, total from orders table, product name from products table
public record ReportDTO(String name, Date order_date, double total) {}

DTO : Data transfer objects.

public record Book(int id, String title, double price) {}

Book b = new Book(35, "Java Ref", 890.00);

=========================


Map is a key/value pair of storage like dictionary, registry
HashMap, LinkedHashMap and TreeMap are popular implementations used of Map interface.
Map produces collection. It is a Set of keys, List of values

Key has to be unique, values can be duplicated

```

Map<String, List<Product>> data  = ..

// key is Class, value is again a map of StudentID and Marks
Map<String, Map<String, Integer>>  studentReports =  ..

```

Annotation:
are metadata; data about data; additional information

Built-in annotation : @Override, @SuppressWarnings, ...

Questions to be asked:
1) Who is using annotation?
    a) COMPILER
    b) CLASSLOADER
    c) RUNTIME [ JRE ]

2) Where can i use it?
    a) TYPE {class, interface, annotation, record, enum}
    b) METHOD
    c) CONSTRUCTOR
    d) Fields
    e) PARAMETERS

@Override annotation is used by the Compiler, compiler sees the source code and checks if the method signature matches with the base class signature.
If it matches compiler compiles the class, else compiler error.

```
    class Base {
        public void doTask() {

        }
    }

    class Derived extends Base {
        @Override
        public void dotask() { // compiler fails

        }
    } 

    Base b = new Derived();
    b.doTask();

```

Rules of overriding:

1) method name has to be same
2) return type can be same or it's sub type
3) visiblity has to be same or enhance it, can't reduce the visibilty

```
    class Account {
        public Account getAccount() {...}

        void doTask() {} // default visiblity
    }

    class SavingsAccount {
        @Override
        public SavingsAccount getAccount() { ...}

        @Override
        public void doTask() {..} // enhance the visibility
    }

```

User defined Annotation example:
Mobile is an annotation

```
@Target(TYPE)
@Retention(CLASS)
public @interface Mobile {
    String os();
}

@Mobile(os="android")
public class CandyCrush extends Game {

}

```

Compiler ignores the annotation and carries it into .class file

if we customize compiler, we can write our own annotations for compiler
if we customize Classloader, we can write our own annotations to be used classloader.

Let's create a sample ORM [ Object Relational Mapping]

I will create 2 annotations like Table and Column

```

@Table(name="books")
public class Book {
    @Column(name="BOOK_ID", type="NUMERIC(10)")
    id;
     @Column(name="BOOK_TITLE")
    title;
     @Column(name="COST", type="NUMERIC(10, 2)")
    price;
}


SET the property:
name="books"

GET the Property:
String str = name();
```


@Retention(SOURCE) : for Compiler, compiler after compilation will remove the metadata from .class file

@Retention(CLASS) : for CLASSLOADER, compiler keeps the metadata in .class file, classloader after loading the class in JRE-METASPACE, it removes the metadata from class definifition in metaspace

@Retention(RUNTIME): compiler keeps it in .class file , classloader also keeps it metaspace, JRE can read it.


```

http://localhost:8080/products

@WebServlet("/products")
public class ProductServlet extends Servlet {

}

```


We need a utility class / annotation processor to read annotations and generate SQL for us.

AnnotationProcessor.generateCreateStatement(Employee.class); --> CREATE Table ..
AnnotationProcessor.generateCreateStatement(Product.class); --> create table

String is immutable, StringBuilder is mutable

More on "Class clazz"

