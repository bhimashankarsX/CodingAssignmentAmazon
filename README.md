# CodingAssignmentAmazon

Framework consists of the following :

src/main
* Driver Engine to instantiate the Appium.
* Generic Utils contains XML READER for external data source and custom methods explicit wait for an element.
* Extent report package has the config for custom extent report.
* TestListeners contains Retry mechanism for the failed test cases and Listner for reporting purpose.
* Page Objects package contains all the Elements and Android alert handler.
* Program Utils is used for general methods like SWIPE etc.

src/test
* Test Runner package has Base class of testNG annotations, and Device control methods.

src/main/Resources
* Has log4j logging properties file.

Execution :

Change the Testing.xml as per requirement and execute it as testNG suite.
