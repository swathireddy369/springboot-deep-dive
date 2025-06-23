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
- 
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

### Week-2-Day-8 ###

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

### Week-2-Day-9 ###
 Response entity is a wrapper used to send complete http response to client from conteoller
 (wraps body,status and header)
normally we send response in springboot simply by usinmg return 
@Responsebody - tells spring to serialize(converts into json) the response into http response
where as in controller we should mention @ResponseBody otherwise it should be treating response as view
 so if we want to send status,headers and body we use ResponseEntity< here w emnetion body type either string int or object>
# build() (typically for status only responses)
we use build in response entity since sometimes we don;t need to send any data to client at that case we use .build() at the end after appending status and headers
means no body is going to append

status types:
1XX - info - just signal
2XX - success - evertyhing is fine
3XX - redirect - go somewhere else
4XX - client mistake - client error
5Xx - server mistake - server error

100 - 100 continue

200 - success - put,get,delete
201 - created - post
204 - no content - delete

400 - bad request - /id (id mismatch)
401 - unauthorized - no logged in
403 - forbidden  - authorized not no permission
404 - not found (api or method wrong)

500 - internal server  error

### Week-2-Day-10 ###

# server.servlet.context-path = /api/v1 (it adds prefix to all routes in our application not for specific controller
)
Exception handler

we have 3 exceptionHandler resolvers

1)exceptionHandlerExceptionResolver
 - controller advice (global)
 - exceptionHandler   
2)responseStatusExceptionResolver
3)defaultHandlerExceptionResolver

any exception occures it follows the order like first it goes to exceptionHanlderExceptionResolver
if the exception has been handled by thisnresolver then it goes to defaultAttribute(final one)
else it goes to responsestatusExceptionResolver here if it is handled by this resolver okay it goes to defaultattribute(final)
otherwise it goes to defaultHandlerExceptionResolver

since while handling if we return responseEntitiy then fine it's gong to return from there itself otherwise let say
if we return string or Httpresponse then again it goes to defaultAttribute and there it sets status and message which w eset in Httpresponse 

Lets see example for excpetionHanlding:

@ControllerAdvice: it is used to handle global exception
@exceptionHandler: used to handle specific exceptions
@responseStatus: used to annotate exceptions with http status
responseStatusException: used to throw inline exception with http status
Responseentity used to send complete response

# JDBC:

Application Logic - ORM framework(JPA(interface),Hibernate(implemenation) options: eclipseLink,openJPA) - JDBC (interface) - specific driver implementation
 as per db - database
JPA : it is interface it allow us to connect from our service to db as it's a interface it provides a methods to implemente
Hibernate: it provides implemenation for methods which are provided by JPA (we have other implemetation optins as well as mentioned above)

JDBC - interface it provides methods to connect with db and execute queries
specific driver for JDBC implementation - 
h2- connector
mysql- jdbc drvier
postgresql - jdbc drvier

as per the database which we are using.


if we have to use jdbc without spring following steps to follow:
have to add jdbc in dependencies 
and driver dependency as well
# step 1: have to load driver class class.forName();
# step 2: get connection to database
# step 3: make a conncetion
# step 4: prepare query and execute query
#step 5: have to close the db and prepared query otherwise we may have memory leakage

# so using springboot we avoid all these boiler plate code
first we have to mentions jdbc and driver in application.properties 

# where this connection will help us to create conection and creates connection pool with default size as well
so we have mutiple datasources as we are using hikara datasource

# we can also create bean for this connection in app config by mentioning bean

so now jdbc with springboot 
we use jdbc template to execute query

althought, it abstarct the connection creation
preapring query
closing connection and query
# while using plain jdbc it gives us sql exceptions if anythings occurs wrong whereas in jdbc with spring it give granual errors (specific meaningfull errors)

jdbc methods to run queries:

update with varargs
update with preparedStatement
query rowmapping
queryForList
queryForObject
queryForObject

JDBC (Low Level) ─┬─ Plain JDBC → More Code (Manual connection/close/error)

└─ Spring JDBC (JdbcTemplate)
├─ Auto connection via DataSource
├─ Auto cleanup (close)
├─ Exception Translation
└─ Easy methods to run queries
├─ update()
├─ query()
├─ queryForObject()
└─ queryForList()
usually we get the result from query as a list of rows right
spring does not know how to convert that into java object right so that's where useRowMapper class of rowmapper interface comesinto piture to tell spring how to covert rouw into javaobjects it has been abstarcted

# JPA:
Steps to follow to enable JPA in our springboot app

1) add JPA dependecny (comes with hidernate as well)
2) add application.properties for db configuartion
3) create entities (object represenation of tables)
4) repository which implement JPA repository (repo should be created for each entity since we do some manual methods like findbyusernameandid )

# To see the results we also can enale console which is diff from diff DB's

Architecture of JPA: 

persistance unit ( application properties) --> (1:1) EntityManagerFactory(object) --> (1:Many) --> EntityManagerObject 
-->(1:1) peristance context (it holds entities which has been managed by entity manager ) --> JDBC -->Database

# Persistance unit:
 - unit is a logical seperation of enties which sahres common configration
 - application properties for each app
 - if we want to collabarte with multiple db's we will be creating multiple peristance units 
 - although for one P.U we can use app.prop where as if you want to create multiple you have to use appconfig @Configuration by providing beans for multiple persistance units
 - have to provde transaction type default one for spring is Resource-local if we create for multiple dbs using config we have to mention manually
# Entity manager Factory:
 - entity manager factory is created as per numer of persiatnce units 
 - its 1:1 mapping 
 - need to privde transaction type like Resopuce-local,dialect,datasource and component scan where as creating one persitance unit in app.prop does not require all these extarc manual things it has been gtaken care by spring itself
 - Transaction manager asscocited with entity manager factory 
 - h2-1T.M MySql - 1TM
# Tramnsaction Manager
 two types as per trabsaction manager hierachy diagrma seen befroe

if one db single transactyion manager 
if multiple then JTA(Associated with DB) will be handle JTA (2phase commit) distributes trabscations
all these above steps wilol be done while starting up the applications

# Entity manager and peristance context
 - Entity manager factory can create multiple entity managers which handles the entities 
 - entity managwer provides the insert,update and deelte operation for db
 - like while we call these methods by using JPAreposity underthehood spring uses entoyymanager.persist and other 
 - now we can dout like why can't we diretly call entitty manager.methods to do operations on db instead of JPA reposity 
 - yes we can but some restritions
 - bacasue JPA repo provides some default methods tp get data from db like find,findall and it suippoer pagination,sorting where in entitymanger does not allow those and 
   one important aspect is owhile using E.M we have to provide transatiuon for each and evry method like insert,update and elete if not it throws exceptions 
  but in JPA repo that is noit thye case
 - once we create E.M object it means in hiderbate session created once session ends we have to create again
 - means if we use entity manager it behind calls hibernate,dilect,jdbc and interact witg db but all these are abstarcted
# peristance context
 - itr is 1:1 with E.M 
  - once E.M created then it peristanbce context is created it holds the entities which has been managed by E.M and persist to db
  - till it persisting to db it hold in its own contxt from cointex we can remove,update and flus to db
  - whenever you flush then only it will be uypdate in DB otherwise it wont means 
  - from context we cahneg status of entoty to diff state removed to manged vice vesa
simple worlds it manages the compole lyfe cycle of Entoty

# Entity
 - entity is transaction bounded nbut nit for all like read does not need transactions
 - but in JPA it provides by default where E.M does not provide by default we have to provide otheriwse it does wpork as mentioned before

E.M holds E1,E2,E3 where as P.C hold placeholder for thos Entity and it intecrt woth DB (hibernate,dilect(jpql,hql - sql),jdbc) - db
dilect transforms java persistance query languiage or hibernate query languagfe into sql to udnerstand jdbc 


. Steps to Enable JPA
Perfect summary!
- Add JPA dependency (via Spring Boot Starter Data JPA)
- Configure application.properties for DB connection
- Define entity classes
- Create repositories by extending JpaRepository
2. Console Output & Visibility
   Yes—you can enable logging to see SQL queries. Each DB may need specific config (like spring.jpa.show-sql=true or setting a logging level for Hibernate).

🧠 Architecture Clarified: From Persistence Unit to DB
Let me cleanly align the components you described and their relationships:
Persistence Unit (app config)
➝ EntityManagerFactory (1:1)
➝ EntityManager (1:many)
➝ Persistence Context (1:1)
➝ Hibernate/Dialect ➝ JDBC ➝ Database
- Persistence Unit
- Logical unit that groups config + entities
- For multiple databases: Define separate persistence units using @Configuration classes and separate DataSource, EntityManagerFactory, and TransactionManager beans
- Resource-local transaction type is indeed Spring Boot’s default unless using JTA for distributed txs
- EntityManagerFactory
- One per persistence unit
- Boot automatically wires it if there's one DB (via Spring Boot auto-config)
- Manual setup only needed if you're connecting to multiple DBs
- Responsible for creating EntityManager instances
- EntityManager & Persistence Context
- Think of EntityManager as your DB API
- Persistence Context is like its memory—it tracks entity state (Managed, Detached, Removed)
- Without a transaction, EM methods won’t flush changes; JPA repo handles
- - transactions for you
- Hence, using JPA repo is more convenient unless you need fine control
- Transaction Manager
- Spring uses PlatformTransactionManager
- Single DB ➝ one TM; Multi DB ➝ use JTA or define multiple TMs
- JTA manages distributed txs using 2-phase commit

💡 Mental Model to Remember JPA
Imagine your app is a factory:
- Blueprints (Entity classes)
  Represent tables with structure and relationships.
- Assembly Line Manager (EntityManager)
  Handles how objects (rows) are created, tracked, or updated.
- Factory Memory (Persistence Context)
  Keeps track of all objects being assembled so nothing gets lost until it’s committed to the warehouse (DB).
- Warehouse (Database)
  Where the finished products live!
- Control Panel (JPA Repository)
  Pre-built methods to query without doing manual SQL—easy mode! But if you want fine control (like crafting your own gears), use EntityManager directly.

🛠 Minor Corrections & Suggestions
- Typo cleanup:
  "hidernate" ➝ Hibernate
  "dilect" ➝ dialect
- "deelte" ➝ delete
    "peristanbce" ➝ persistence
    And a few others—minor, but fixing them will make your notes even more professional.
- Clarify: JPA does not execute queries by itself. It relies on Hibernate (or another provider) to translate JPQL into SQL via the dialect.
- One neat trick: @Transactional on methods ensures automatic transaction wrapping if you ever move beyond JPA repo.


### Week-2-Day-11 ###

JPA setup : created userEntity

Add DB config in app.properties

controller 
service
repo -implements JPA repository

//show sql -true

i am trying to return a complete entity but i got issue because 
hibernate returns proxy of entoty not orginal one bacause it lazy loads the entity
so this proxy conatins lazyinitilizer so jackson doesnot know how to hanlde those proxy objects
+-------------------------------------+
|         Spring Boot / JPA           |
+-------------------------------------+
|
v
+-------------------------------+
|    Controller (REST API)      |
+-------------------------------+
|
v
+-------------------------------+
|       Service Layer           |
+-------------------------------+
|                    |
v                    v
[Entity ↔ DTO] Mapping   [Business Logic]
|
v
+-----------------------------+
|   Entity (JPA/Hibernate)    |
+-----------------------------+
|
v
Hibernate returns a **Proxy** 🕵️‍♀️
|
┌──────────────────────────────┐
|  Lazy Loading Proxy Issues:  |
|  - Infinite Recursion        |
|  - Serialization Fails       |
|  - Jackson doesn't know      |
|    how to handle proxy       |
└──────────────────────────────┘
|
🛑 Exposing Entity to API = Bad
|
v
✅ Use DTOs to break proxy and:
- Serialize cleanly
- Expose only safe fields
- Avoid LazyInitializationException
- Keep controller clean
- Avoid tight coupling
  https://chatgpt.com/share/68588cb3-2e94-8010-a3fa-d7445501fc63
here one more observation:
- Hibernate: select ee1_0.id,ee1_0.age,ee1_0.name from employee_entity ee1_0 where ee1_0.id=?
  Hibernate: insert into employee_entity (age,name,id) values (?,?,?)
- i put save user first but i got select query in log since it check before inserting wether already id record exist or not 
- if not it saving new record otherwise its updating 
- that is why i got frist sleect query (****************)

- made id as auto generaed @GeneratedValue(strategy=Generation.IDENTITY)

- i observed that first level caching working here 
   - if we hit same query agin then it just giving it from percistanceContext instead fo hitting query to db
   - so this cache is created for each HTTP request at dispacther servlet level
   - once http reuqest comes in cahce will be created with single tranascation 
   - as we know in one transaction data can be shared among them 
   - when session or entity manager created (while http reuest comes in) transaction will be created 
   - once transction done cache will be gone
# Second Level Caching 
- this is another tyoe of caching where in first level caching for each http reuqest they have one cache 
- but second level cache is next to that which is shared among diff http request by having lock and realsing lock while writting on dasta
- to enable this in our applicstion we need dependecies whereas in first level caching it;s automatic
- need 3 dependencies
- ecache
- <!-- Ehcache 3 -->
<dependency>
    <groupId>org.ehcache</groupId>
    <artifactId>ehcache</artifactId>
</dependency>

<!-- Hibernate JCache integration -->
<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-jcache</artifactId>
</dependency>

<!-- JSR 107 (JCache API) -->
<dependency>
    <groupId>javax.cache</groupId>
    <artifactId>cache-api</artifactId>
</dependency>

- after adding dependencies have to add in application.properties
- and have to add ehcache config file for each entity seperately in our resources folder
- have to provide cache annoation at each entity
- we have mutiple concurenacy staregies 
- Read_ONLY : shared lock will aquires cache and multiple request can access cahe data while shared lock acquired
- READ_WRITE : shared and exclucsive both can happen as per the operation which we are doing while reading shared lock will acquire where as write exclusive lock no other querues can be processed till it unclick and it marks cache as invalidated 
  if transaction commits then db updated and cache also updated removes invalidated flag
rollback: it puts invalidated flag itslef ,if any query comes then it goes to db to get data and then it updated cache then it removes invalidated flag
- NONRESCTRICT_READ_WRITE: here no lock for read 
although write lock like above case but once commit happens it does not remove invalidate flag and does not have updated data 
next any other query gets data from db and then it updates cache and removes invalidated flag
- Transactional: 

### Week-1-Day-12 ###

findById: returns Optional where you're not sure weather the entity present or not(safeCheck)
getById: returns proxy entity first(lazy loads) returns real entity when required(needed when you;re sure that the entity exist)
if you perform getById and entity does not exist then there is a chance to get jakson serialization issuse which we got yesturday
so as we didn't  aware of this difference we made id as autogenerated value now i got clear picture of this

# added queries formate true for jp.properties.hibernate.formate.queries =true
# got clear ides about ResponseEntity<?>
--- READ_ONLY : 
we cnnot do put operations
---READ_WRITE
after update the cache makes it as invalidated so we have to go to db and fecth the data and update it into cahce next onwards cache will give data
//enable logging for cache and there is concept called springcache (didn't cover yet)
//redis and ehcache (differeces
https://chatgpt.com/share/68594d30-1620-8010-a4f1-35a6c0c6b195)

read -write after getbyid should hit db as per my knowledge in progress














_