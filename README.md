**Test Automation Framework (Java + TestNG)**

A well-structured **Java-based Test Automation Framework** built for scalability and maintainability using **TestNG** and **Maven**, following the **Page Object Model (POM)** design pattern.

It supports **data-driven testing** with CSV, Excel (Apache POI), and JSON, along with dynamic test data generation using Faker. The framework enables **cross-browser execution** on both local and **LambdaTest cloud**, with configurable parameters like browser type, headless mode, and execution environment.

Designed for **CI/CD integration** using Maven Surefire, it also includes **Extent Reports for reporting** and **Log4j for logging**, making test execution, debugging, and analysis efficient. The architecture is modular and easily extendable for future enhancements.

## 🚀 About Me
Hii, My name is Umesh kute and I have 2 years of Experience in Automation Testing using Technologies like Selenium WebDriver. API Testing through Postman. 

My Major experties in Java Programming language.

## Authors

- [@qa-Umesh](https://github.com/qa-Umesh)
- Email- umeshkute453@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/qa-Umesh)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](www.linkedin.com/in/-umesh-)



## Tech Stack

- **Language**: Java 11 /Selenium Webdriver
- **Test Framework**: TestNG
- **Build Tool**: Maven
- **Data Handling**: CSV, Excel, JSON
- **Libraries Used**:
Apache POI (Excel handling)
GSon (Json data handling)
Faker (test data generation)
- **Logging**: Log4j
- **Reporting**: Extent Reports
- **Cloud Execution**: LambdaTest
- **Execution Modes**:
Headed
Headless
- **CI Execution**: Maven Surefire Plugin


## Features

- Page Object Model (POM) design pattern
- Data-driven testing (CSV, Excel, JSON)
- Dynamic test data generation using Faker
- Cross-browser execution
- Cloud execution using LambdaTest
- Headless execution support
- Detailed reporting with Extent Reports
- Logging using Log4j
- CI/CD ready using Maven Surefire


## Installation

**clone the Repository**

```bash
git clone https://github.com/qa-Umesh/Test-Automation-Framework.git
cd  <project-folder>

```

**Run the test on Lambda Test**

```bash
mvn clean test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false
```

**Run on Chrome (Local)**

```bash
mvn clean test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=false
```

**Run Headless Mode**

```bash
mvn clean test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true
```


## Reports
After execution, reports are generated at:

/reports.html


## Integrated the project GitHub Actions
this automation framework is integrated with github action.
the tests will executed at 11:00 PM(IST) every single day. 

this reports will be archived in gh-pages branch 
you can view the html report at:
https://qa-umesh.github.io/Test-Automation-Framework/reports.html
