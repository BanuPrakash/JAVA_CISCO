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



