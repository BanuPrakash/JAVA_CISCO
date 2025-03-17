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

