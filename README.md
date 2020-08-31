**API Testing Framework**

This Framework is designed for Backend Testing of Webservices using Java with RestAssured and Serenity utilizing Maven as dependency management tool. 
Data Driven Test strategy is used to design and execute tests.

**Technology Stack**

* Java
* Serenity
* Maven
* RestAssured

**Prerequisites**

* Java 1.8 - Java Dev Kit
* Maven - Dependency Manager
* IntelliJ IDEA - IDE

**Project Structure**

models: This directory contains all the response pojos of each json placeholder endpoint
api: This package contains methods
testcases: This package contains Test cases 
util: This package contains Utility Classes

**Installation**

Open the project in IntelliJ. Run the following command in Terminal and build the project. It will automatically download all the required dependencies.

`$ mvn clean install`

If the build is successful. All the required dependencies are installed successfully. But if the build fails, make sure to to resolve all the issues in order to execute tests successfully. Make sure that config.properties path in Property Reader class is set according to your Operating System Environment.

**Execute Tests**

Run the following command in Terminal to execute tests.

`$ mvn clean test`

`$ mvn clean verify`

**Test Report**

You can find the Serenity HTML reports in the following directory of the Project.
*  \target\site\serenity\index.html
* \target\site\serenity\serenity-summary.html

Under the site-reports directory, open ‘index.html’ and serenity-summary.html file to view reports.
