# Test Automation Framework

Scalable Java test automation framework using Selenium WebDriver, TestNG and LambdaTest.

## Features
- Parallel execution
- Data-driven testing (CSV/JSON/Excel)
- Cross-browser testing
- POM architecture
- Retry listeners
- Extent Reports
- Environment-based configuration

## Run Tests

Run locally (headless Firefox):

```bash
mvn clean test -Dbrowser=firefox -DisLamdaTest=false -DisheadLess=true
```

Run on LambdaTest cloud:

```bash
mvn clean test -Dbrowser=chrome -DisLamdaTest=true -DisheadLess=false
```
