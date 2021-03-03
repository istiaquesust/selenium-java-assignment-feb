# selenium-java-assignment-feb

## Introduction
This repository is a Java project of selenium automation, created to accomplish two assignments that are seperated in two directories assignment_1 and assignment_2 based on the given tasks. In code structure Page Object Model pattern is followed. To change any data like user, password go to properties/config.properties file and edit the value. By default the driver is set for chrome - also firefox support is provided. Update BROWSER_NAME=firefox in properties/config.properties file for firefox execution. Intentionally for simplicity no testing framework (JUnit, TestNG) is used. 
## Steps of Execution
1. Clone the project.
2. Add Selenium 3 jar files in the Classpath.
3. Set DRIVER_PATH from properties/config.properties file - set BROWSER_NAME=chrome for chrome driver or set BROWSER_NAME=firefox for firefox driver.
4. Open assignment_1._test_cases FBTestCase.java and run as java application for assignment_1.
5. Open assignment_2._test_cases WHReviewTestCase.java and run as java application for assignment_2.


