# ChatBot Test

This repository is meant for creating and executing chatbot automated test cases.

Contact People for queries :

1. Vinita Kaushal

Highlights of the repo :

1. Tests in this repo covers functional validation of IRA chatbot.
2. High level Tech Stack used :

    a. Java & Selenide
    
    b. TestNG
    

### Pre-requisite
* JDK 8
* IDE, prefer [IntelliJ Idea CE](https://www.jetbrains.com/idea/download/download-thanks.html?platform=mac&code=IIC)


### Setting up the project locally:
* `git clone https://github.com/vinitakaushal/chatBot.git
* Ensure TestNG plugin is working
* Rebuild project locally using `mvn clean install`.


### Running Test Suites
* For Test Execution through IDE:
	- Goto Suites folder and right click ChatBotValidation.xml and click Run As TestNG Suite
  
* For Test Execution through command:  
mvn clean test -DsuiteXmlFile=src/test/java/Suites/ChatBotValidation.xml

## Reports
* <u>Local Reports</u>
    * Running tests locally , reports are stored in `/build/reports/*`.
    * Open `index.html` and 'emailable-report.html' to view the reports in a web browser 