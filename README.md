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