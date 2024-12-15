
# Spring Boot 


## IMP keywords:


### Aplication Context

ApplicationContext is a central interface in the Spring Framework that represents the Spring IoC (Inversion of Control) container. It is responsible for managing the entire lifecycle of application beans and provides advanced features beyond basic dependency injection.
 
#### Core Responsibilities:


* Bean creation and management
* Dependency injection
* Configuration of application components
* Providing access to application beans
* Managing bean lifecycle


#### Types of ApplicationContext Implementations:


* `ClassPathXmlApplicationContext`
        Loads context definition from XML files in classpath

* `FileSystemXmlApplicationContext`
        Loads context from file system XML

* `AnnotationConfigApplicationContext` 
        Loads beans from Java configuration classes

* `WebApplicationContext`
        Specialized context for web applications



### getBean()


`getBean()` is a method in Spring's ApplicationContext that allows you to retrieve (fetch) a bean manually from the Spring container.


### Bean

A bean is an object that is:


Managed by the Spring IoC (Inversion of Control) container

## SpringBoot

### Autowired

_**It is known as FIELD INJECTION**_

`@Autowired` is a Spring annotation used for automatic dependency injection. It allows Spring to automatically resolve and inject dependencies into a bean.

#### Primary Purpose


* Automatically wire dependencies
* Eliminate explicit configuration
* Reduce boilerplate code for dependency injection


### There are three types of injections:

* #### Field injection
* #### Constructor injection
* #### Setter injection


#### Field injection:

     @Autowired                   
     private Second second; 

* A Spring annotation that automatically connects (injects) required dependencies
* Tells Spring "Please find and connect the right object for me"
* Reduces manual object creation and connection



#### Constructor injection:

       public First( Second second) {         
       this.second = second;
       }

* Dependencies are passed through the class constructor
* Most recommended approach
* Creates objects with all required dependencies ready
* Makes dependencies clear and immutable



#### Setter injection

    @Autowired                                  
    public void setSecond(Second second) {
    this.second = second;
    }

* Dependencies are set using setter methods
* More flexible than constructor injection
* Allows changing dependencies after object creation
* Less preferred compared to constructor injection



#### Keywords used to specify the priority of the class to be executed when two classes implements a class(x) and the class(x) is autowired 

    @Qualifier("second_part2")
  Used in the class where it is called



    @Primary
  Used in the class to be given the priority



## Spring 
#### This is how we create an object and call the method of different class to execute the body



    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
     First first=context.getBean(First.class);
     first.develop();


### Setter Injection (In only Spring without boot)

_In the class where the variable is present_ 

      public int getAge() {
      return age;
      }


       public void setAge(int age) {
       this.age = age;
       }


_In the spring.xml file_:

For a variable:

     <bean id="first" class="com.Spring.First>"
         <property name="age" value="20"/>
        <property name="salary" value="1900000"/>
    </bean>

#### **For a different class**:

In the file where the obj of Second class is to be called:

    public Second getSecond() {
        return second;
    }
    public void setSecond(Second second) {
        this.second = second;
    }

_In the spring.xml file_:


This line will be inside the bean of first class only:
         
      <property name="second" ref="second_id"/>

This will be written as a seperate bean for seconf=d class:
 
     <bean id="second_id" class="com.Spring.Second">
      </bean>


### Constructor Injection(In only Spring without boot)


_In the class where the variable is present_

    public First(int age,int salary) {
        this.age = age;
        this.salary=salary;
    }


_In the spring.xml file_:

For a variable:

     <bean id="first1" class="com.Spring.First">
        <constructor-arg index="0" value="19"/>
        <constructor-arg index="1" value="2000000"/>
      </bean>


### Autowire (In only Spring without boot)

Autowiring can be done by just adding the atribute in the bean of the class itself
We have two atribute for this:


* #### byName


`<property name="sec" ref="sec"/>`

   This works when the name and ref both are same, then what it does is it will automatically search for an instant variable in the class "first" for name and will connect it to the class having the ID same as the instant variable name i.e. "sec" in this case.
 


     `<bean id="first" class="com.Spring.First" autowire="byName">`

* #### byType

`<bean id="sec" class="com.Spring.Second" primary="true">`

`<bean id="second_part2ID" class="com.Spring.Second_part2">`

Both these id belongs to same type as they extends the same class,
so spring will be confused which class to choose and print therefore we can add the atribute
`primary="true"`
which shows the priority of the respective class over other.

      <bean id="first" class="com.Spring.First" autowire="byType">
      <bean id="sec" class="com.Spring.Second" primary="true">
      


### In App.java:

In this it is searching by the ID name `"sec"` and it is the reason we need to type cast it into an obj by adding `(Second)` before it:

    Second second=(Second) context.getBean("sec");


In this it is searching the type of the class therefore no need for type casting:

      Second second= context.getBean(InterfaceOfSecond.class);

## Web_Project with SpringBoot

Dependencies included:

* _Spring Web_
* _Spring Boot WebTools_



        @RestController


`@RestController` is a special annotation in Spring Boot used to create web services and APIs that **return data directly instead of web pages**.




        @RequestMapping(" ")

`@RequestMapping(" ")` Annotation **used to map web requests to specific handler** methods
Defines the URL path for a controller or method.


Example:


          @RestController
          public class Home {

          @RequestMapping("/") 
           //    @ResponseBody  // it is also used as @RestController
           public String greet() {

           return "Hello, Its Devina here!";
            }

Like this we can create many RequestMapping for different URLs like "/", "/about" etc.


### MVC (Model View Controller)

Basic Analogy: Restaurant Model

Imagine a restaurant:


* Chef (**Model**): Prepares food, manages ingredients
* Waiter (**Controller**): Takes orders, communicates between customer and kitchen
* Dining Area (**View**): Where customers see and receive their food 

### MODEL (Data Layer)

* Represents your data and business logic
* Manages database interactions
* Handles data processing    

           @Entity
           public class User {
           private String name;
           private String email;
           // Data storage and business rules
           }

### View (Presentation Layer)

* What user sees
* Displays data to the user
* HTML, frontend pages

        <div>
        <h1>User Profile</h1>
        <p>Name: ${user.name}</p>
        </div>

### Controller (Interaction Layer)

* Manages communication
* Processes user requests
* Connects Model and View

        @RestController
        public class HomeController {

        @RequestMapping("/")
        //    @ResponseBody
        public String greet() {

        return "Hello, Its Devina here!";
        }

#### Rest API uses a protocol called HTTP which has certain method:

### HTTP

HTTP stands for: **Hypertext Transfer Protocol**
* A language computers use to communicate over the internet
* Rules for sending and receiving information
* Like a postal system for digital data

##### Key Components:

* **Request:** What client wants
* **Response:** What server sends back
* **URL:** Address of the destination
* **Methods:** Types of requests

#### Common HTTP Methods

* **POST**: Store something on the server

* **GET**: Fetch something

* **PUT**: Update existing information

* **DELETE**: Remove information

### CRUD( Create, Read, Update, Delete)
With help of the methods we can perform the CRUD operations.

##### Status Codes


* 200: Success (Everything worked)
* 404: Not Found (Wrong address)
* 500: Server Error (Something broke)


       Browser → HTTP Request → Server
       Server → HTTP Response → Browser


### Stream() 

Part of the Java Streams API.

* A way to process collections of data
* Allows easy and powerful data manipulation

Why Use Streams?


* Simplify complex data operations
* Write more readable code
* Perform operations easily
* Handle large datasets efficiently

Example:

            return products.stream()
           .filter(p -> p.getProdId() == prodId)
           .findFirst().get();


### @PathVariable

`@PathVariable` is used to extract values from the URL path in a REST controller. It's commonly used when the URL contains dynamic parts, and you want to use those parts as parameters in your method.


            @GetMapping("/products/{prodId}")
            public Product getProductById(@PathVariable int prodId) {
            return productService.getProductById(prodId);
            }   


### @RequestBody

It is responsible to get the data in the request and then send that it the reference.
`@RequestBody` is used to bind the body of an HTTP request to a Java object


     @PostMapping("/products")
     public void addProduct(@RequestBody Product prod) {
     productService.addProduct(prod);
     }


