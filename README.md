*** 06/10/2025 ***
### Week-1-Day-1 ###
# Spring MVC
# SpringBoot
# Maven setup
# local git
# Linked to remote
# push and pull from remote
# Servlet and servlet container
  # Servlet
  Before spring introduced we used have servlet and servlet container to manage servlets
  - servlet is a class where we define api's and corresponding methods to it restricted to single GET,PUT,POST,DELETE for each servlet
  - servlet1class extends servlet
  - and implements the abstract methods of servlet class
 # servlet container
  servlet container is one manages the servletclass
 # web.xml
  - it maps servletclasses and api's
  request->servletcontainer(tomcatserver we have to deploy application by configuring war file)-> it goes to web.xml to check mapping
  once find the servlet for requested api then it calls servlet to execute corresponding api method and process the reqesut and gives the response
  this is the flow of servlet and container where it maintines single crud method for each servelt class and mapping iyt becomes lengthy as we adding multiples api's ity is difficult to read and understand moreover
  while scaning in servletmapping web.xml it goes to filter to find exact api
  by  avoid this issues community introduced spring 
  ### Spring - spring MVC -spring boot ###
  Spring MVC: it rectifies the drawbacks in servlet where it follows @annotation feature 
  @RequestMapping
  @GETMapping no extenral mapping required
  and 
  # inversion control
  lets say if huge model should depend on abstarction instead of concrete classes
  if we a computer class which calling another concrete wiredkeyboardclass method 
then while running computer class have to create object for wiredkeyboardclass
while writting unit test for computer class have to mock this wired class but we cannot mock right
so srpingMVC uses annotation feature to easily mock @autowired it means the computer class mock the wiredclass object instatiation
this is one considerable feature in spring MVC 
although spring MVC has few drawbacks those are we have to config the app to tell servlet where to start scanning for mapping in our application
and have to metion version of dependencies if we changes one dependcy version infuture it may or may not compatable with other version dependencies
so by rectifying all these drawbacks spring boot introduced with minimal setup, autoconfiguration adn embedded server 

1) Auto configuration - springboot by default proivdes config for app and allow convetion over conig menas we want to cofig again we can override)
2) Dependency management - no need of mentioning versions for dependencies)
3) embedded server - No need to deploy manuallay tomcatserver comes outlofbox from springboot
# Maven setup:
- took ultimate subscription using student mail
- added local git 
- linked to remote
- pull and push done (*****************)

Maven Setup Folder struture or flow of execution:

Request(client) -> controller -> service(business logic) ->repository ->DBMS

->DTO -> Utility -> Entity ->configuration


### Week-1-Day-2 ###

1)mvn validate
2)mvn compile (target)
3)mvn package (.jar file)
4)mvn test (run test)
5)mvn verfiy( we can add extra static check like style, specify in pom.xml and verify phase and provides warning if ny unused imports,variables,duplicate case have to metion pmd in our pom.xml to do this it has been develped by some develoepr and deployed in mvn package) 
6)mvn install(it install packages and jar in our local repository)
7)mvn deploy ( it will deploy our jar file in rempote repo (either our companry remote repo or maven centarl repo)) but here its asking credentialsd for mavemn central as well if we want to download it does not ask any credentials to download whereas oit does ask for credentials if you have to deploy 

# Annotations
 1)Controller
 -@Contoller
 -@RequestMapping(requires spring-boot-web-starter depndency)
 -@Responsebody (without this it method returs view and it tryes to check for view and render it)
 2)RestController
 did a mistake wasted 2hours of time
 3)RequestParam
 4)PathVariable
 5)RequestBody
 6)ResponseBody
#downloaded postman
 i have tested all these annotations with simple examples


### Week-1-Day-3 ###
@Component
@Configuration
@Bean(method)(paramterised construtor)
@Autowired(dependency injection)
@Lazy(only initilized when needed unlike eagerness)
@PostConstruct
@PreDestroy

->applicationcontextloaded -> bean created -> dependencyinjectedintobeanconatiner -> postcreation -> bean ussage-> preDestroy ->Destroy


# Dependency Injection & Dependency Inversion 
Dependency injection helps us to achieve Dependency inversion principle
1)Field Dependency Injection
2)Setter Injection
3)constructor Injection

Reflection: is a program to examine and modify itself while running


Scopes:
SingleTon: one object for rntire IOC no matter and eagerly
Prototype: multiple objects creates for each use and lazy

### Week-1-Day-4 ###

Request: single bean for each http reuqest
session: session will be created for each session not for request
Application: single bean shared among multiple iocs

As per D principle we have to depend on abstraction instead of concrete classes
so what if we have mutiple implemenations how can we inject particular implemenation lets how can we say to springboot to create bean of particular implementaion nin runtime
we have @primary and @qualifier right but here statically we are mentioning or depending on concrete classes right and it voilets the d principles
so to provide dynamically we have two options

1)mention qualifiers for all implemenations and one thing need to check (************)

2)use @Value annoation to provide bean config dynamically
one point got to know that in app properties should not put quotes and semicolon 

# @ConditionalOnProperty

having multiple unneccesary beans in container may slow down the application startup and consumes more memory right so to avoid that  we can put conditions on bean creation

let's say in product based companies always migrate data from mysql to sql once migration is done we can stop creating bean with one of them right,
that is one considerable case to use conditionalonproperty

let's say if we have common codebase for two applications and wants to create bean for one app at a time 

# @Profile
Profiles : profiles are nothing but  different environments which we can run  our application like
# dev
# qa
# prod
we have to tell springboot to run our application in particular environment where each environment contains different
configurations nd required credentials
url,port and other like username,password urland port 
so that we create
# application-dev.properties
# application-qa.properties
# application-prod.properties
and add specific config for them lets say username and password and mentions

provide  default values for which we provided through profiles conf 
in application.properties, by default spring will choose application.properties if no profile is active

to set the profile active use 
# spring.profiles.active = dev,prod,qa
1)this is the manual/static thing which we put in app.properties
to make it dynamic we have options like, while running application mention inj command like 
# mvn spring-boot:run-Dspring-boot.profiles.active=prod
2)or edit configuration in intellij and run
 if we put manual config active profile in app.properties and again if you mention in command while running it will override
  the command one will have more priority
# @Profile
coming to the usage of @Profile it used to mention at the class level to specify weather the bean of the component should be created or not  while mentioned profile is active
# Profile("dev")
# Profile("qa")
# Profile("prod")
if # spring.profiles.active= dev,prod but if you mention Profile("dev") you will get prod username and password means bean 
is created because we mention dev in @Profile and is active but you override it with another active env such as prod

AOP: Aspect oriented programming:
 it is a module to maintian boilerplate code and maintaines reusability

lets say some time we wants to writte some code before and after business logic it might be common for few methods right
at that point of time instead of writting same code multiple times we use AOP for that

it conatins pointcut and advice

# pointcut : it defines a condition where the advice should execute.
# advice : it tells that when and what should be execute 

before ,after and around comes under when 
what should execute "it might be some text or logic to execute"
#  @Aspect (for AOP class)
#  @pointcut

we have few types in pointcut
1)execute
  -wildcard 
   # *
   # ..
2)within
  - @within
3)args
  - @args
4)annotation
5)target

***************intersept does not work for static methods and the method whoch has been called in construtor***********




_
### Week-2-Day-5 ###

Transactional:
#critical Section
# inconsistancy
#Acid prop
#dependecny
#driver 
@Transactional

Transaction Manager:
Transaction manager interface (getTransaction.commit,rollback)

extends

PlatformTransactionManager(getTransaction.commit,rollback) 

implements 
AbstractPlatformTransactionManager(getTransaction.commit,rollback) default impmentation

concrete classes
1)DataSourceTransactionManager(JDBC TM)
2)Hibernate
3)JPA

concrete classes
//Distributed transactions
4)JTA

# Transaction Management
can be done in two ways
1)Declarative (through annotation)
2)programatic (through manual coding)
  - two wasy
   1) complete code 
   2) through templateTransaction  

Transaction creation types and rules

propagation : 
# Required (default) :it is default one and if parent exist then use parent otherwise create one 
# RequiredNew : if parent exist suspend parent -create new for child and finish it the resume parent
# Supports : if parent exist use parent, otherwise run without creating
# NonSupports : if parent exist suspend, don't create new one 
# Mandatory : must run inside transaction if non exist throw exception
# Never: opposite to mandatory: if transaction exist throw exception


### Week-2-Day-6 ###
thread pool :
it is a collection of htread are avialbelt o do tasks and once taks is completed they are avilable to take anothe thread in pool
Async Annotation: 
to run particular method in another thread
wthout blocking main thread




1)not providng any executor

if if we want to create poolexecujtor
we can create in two ways

2)spring natoive : threadPoolTaskExecutor
2)java :threadpoolexecutor

# not providng any executor
it checks for executor been if not found this case yes it does not found any so it uses simpleAsyncTaskExecutor
usually spring check for taskexecutir bean if it does not find any then itr creates simpletaskexecutor it creates new tyhread every time
min:8
max: Integer.MAX_VALUE
queue:INTEGER.MAX_VALUE

now spring found this bean the it executes with this

# threadPoolTaskExecutor : it is managed by spring itslef
no need to metion namae
have to mention min,max and queue size

# threadpoolexecutor 
it is java native
so we have to provide name explicitly
it does nit maintianed by spring
have to mention min,max and queue size

here over all 3 use cases

here are possible usecases among all those springthreadpoolTaskExecutor is recommneded although to void confusion among all cases if ypu want to provide a executor which should be default 
then there is a way 

1) AsyncCofigurer (Interface)
getAsyncExecutor (method)
 
among springtaskpoolexecutor recommneded and for global level appconfigurer

### Week-2-Day-7 ###
Async usage conditions and questions:
#  while using async it should not be in the same class where caller is located
if we put in same class proxy and interception will not work as expected
and async menthod should be public 
# async with transaction
while using async with transaction there are 3 ways

1) transaction and async order then if you rollback transaction it will not effect in async method 
2) transaction & async  , transaction here propagation will not work as expected why because async thread will run seperately because it will not carry to next transaction
3) so that order async,transaction would be best way of doing since once you create async and if you use transaction our transaction would be run in separate thread
hence if you create some other transactions later it will carry in that itself

# return type of future,callableFuture future deprecated and callable future cam into indursty from java 1.8

# exception handling: 
lets say if you have return type for async then nits fine as per the returned value we can handle in parent other wise if there is void type of async
we should be handling excpetion in nasync itself
if you want to customize execption then we can use simpleuncaughtexceptionhandler interface to customize 

Handling intercepters: as we know intercepters run some code before and after our businesslgoic right

we can handle them in two ways
1)before controller 
2)after controller
# Before Controller:
we have to implement HandlerIntercepter and override methods
1)preHandler
2)postHandler it executes when no exception 
3)afterHandler it is a kind of finally in try catch

and in appConfig implement WebMvcConfigurer

#AfterController

# custom annotations

public @Interface MyCustomAnnotation {
}

@Target : when should be applicable (method,parameter,filed,class)
@Retention: till where ity can be stored or referenced (source,class,runtime)

### Week-1-Day-8 ###

streams
intermediate -filter,map,sorted
terminal - findFirst,reduce,collect
lazy - intermediate
eager - terminal

method reference: System.out::println()

comparable - compareTo
comparator - comparing

Res-DTO

class: filter and intercepters
HATEOAS: HYDER MEDIA AS THE ENGINE OF THE APPLICATION STATE









_