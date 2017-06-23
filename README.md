# E-Commerce-project---Cucumber-automation-framework
 Hi chaps, Angelo here, I've created a test framework with BDD technique in Java for a dummy Ecommerce application.
 
#1 Background

Cucumber is a test automation tool following the principles of Behavioural Driven Design and living documentation. Specifications are written in a concise human readable form and executed in continuous integration.

This project allows you to have a comprehensive overview on how to implement a BDD framework in Selenium Webdriver with Junit/TestNG test framework. In order for this to work you must install some softwares and plugin as described below. 

#1 Set up and Installations

The prerequisites for running Cucumber Selenium automation test suite:

- Download & Install Java (jdk)
- Download and Install Eclipse
- Download Selenium WebDriver Client
- install browser drivers (i.e. chromedriver)
- Cucumber .jars files and Configure Eclipse
- Install Maven
- Add a maven dependencies to your pom
- import plugins (i.e. cucumber-reporting)

How I’ve created the test automation framework in Cucumber
 
In order to build the framework in Cucumber, I’ve carried out the following steps:
 
#1 Feature files
 
A Feature File is the entry point for a Cucumber test where the features are described in BDD format/style, representing the “scaffolding” for each test.
I’ve built 4 feature files in the feature package. Each of them contains a list of scenarios (positive and negative). 
For example, in the image below illustrates the Login Feature and all of the scenario scripts related to it.
 
These are structured in keywords defined by Gherkin.  
Feature: Defines what feature is being tested
Given: States the pre-condition of the test
And: Defines additional conditions of the test if appropriate 
Then: States the post condition or expected result of the test.
 
#1 Step definitions
 
A Step Definition is a java method in a class with an annotation above it.
An annotation (@Given/ @When/ @Then) followed by the pattern is used to link the Step Definition to all the matching Steps, and the code is what Cucumber will execute when it sees a Gherkin Step. 
 
Based on that, I’ve created the test suite classes in the stepdefinition package. For each of them I’ve defined all the methods with Gherkin annotation (@Given/ @When/ @Then).
Please find below an example of TestSuiteLogin.java class built with the concept of the step definition.
 
#1 Junit Testrunner class
 
With a complete set of stepdefinions I procedeed to the creation of a class for running the tests. Cucumber relies on Junit framework for this purpose.  
I’ve created a new Class file and named it ‘TestRunner‘, by right click on the Package and select New > Class. This class relies on the  annotations to define which one of the cucumber features is being run through (please find screenshot below). 
More in detail, I’ve imported the statement ‘org.junit.runner.RunWith‘ in order to import  the @RunWith annotation from the Junit class. 
Then, I’ve imported the statement ‘cucumber.api.CucumberOptions‘ in order to have access to the @CucumberOptions annotation. This annotation manages the logic under which Cucumber defines where to get a feature file and what reporting system will be used.
 
#1 How to Run the Automation suite with Junit
 
Finally, select the Testrun Junit option and then all the tests will be running correctly. 
 
 
 
