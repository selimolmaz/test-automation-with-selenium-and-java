### Project Overview
This project is a test automation framework for the [saucedemo](https://www.saucedemo.com/) website, built using Java, Selenium, TestNG, and Allure. Its primary goal is to test the login functionality of the application. The framework is designed with a focus on maintainability, scalability, and detailed reporting.

### Project Structure
The project follows a well-structured package organization to separate different concerns:

#### `org.makak.drivers`
This package manages all aspects related to WebDriver.

- **DriverFactory.java**: A factory class that creates WebDriver instances for different browsers (Chrome, Firefox, Edge). It abstracts the process of driver creation, allowing for easy browser switching.
- **DriverManager.java**: Implements the Singleton pattern to ensure that only a single instance of the WebDriver is used throughout the tests. It handles the initialization and termination of the driver instance.
- **DriverType.java**: An enum that defines the supported browser types: CHROME, FIREFOX, and EDGE.

#### `org.makak.page`
This package contains the Page Object Model (POM) classes.

- **LoginPage.java**: Represents the login page of the application, containing locators for web elements (e.g., username field, password field) and methods to interact with them (e.g., `enterUsername`, `enterPassword`, `clickLogin`).

#### `org.makak.test`
This package contains the test classes.

- **BaseTest.java**: A base class that all test classes inherit from. It includes setup and teardown methods (`setUp` and `tearDown`) to initialize and close the browser for each test method. It also has a method to take and attach screenshots to the test report in case of a failure.
- **LoginTest.java**: Contains the actual test case for invalid login scenarios, which is data-driven using a DataProvider.

#### `org.makak.utils`
This package holds utility classes.

- **DataProviders.java**: Provides a DataProvider named `loginData` that reads test data from an external Excel file.
- **ExcelUtil.java**: A utility class that uses the Apache POI library to read data from a specified sheet in an Excel file (.xlsx).

### Design Patterns Used
- **Page Object Model (POM)**: Enhances test maintainability and reduces code duplication by representing web pages as classes.
- **Singleton Pattern**: The `DriverManager` class ensures a single, globally accessible WebDriver instance, which is crucial for managing browser sessions efficiently.
- **Factory Pattern**: The `DriverFactory` provides a flexible way to create different WebDriver instances, decoupling the test code from the specific browser implementation.

### Data Reading
Test data for login scenarios is stored in an Excel file (`loginData.xlsx`) located in the `src/main/resources` directory.

- The `DataProviders.loginData()` method reads this Excel file using `ExcelUtil.getData()`.
- `ExcelUtil.getData()` reads the data from the specified sheet, skipping the header row.
- The data is then converted into a two-dimensional array (`Object[][]`) and passed to the `LoginTest.testInvalidLogin` method by TestNG.

### Reporting
The framework is integrated with Allure to generate comprehensive and detailed test reports.

- `@Step` annotations are used in the `LoginPage` class to provide clear, step-by-step descriptions of actions in the Allure report.
- `@Feature`, `@Story`, and `@Description` annotations in the `LoginTest` class categorize and describe the tests, providing a better overview in the report.
- The `BaseTest` class automatically captures a screenshot upon test failure and attaches it to the Allure report, which is invaluable for debugging.

### How to Set Up and Run the Project

#### Prerequisites
- Java Development Kit (JDK) installed.
- An IDE like IntelliJ IDEA or Eclipse.
- Apache Maven for dependency management.
- **Web Drivers**: Place the Chrome, Firefox, and Edge driver executables in the `src/main/java/org/makak/drivers/drivers_src/` directory.
- **Test Data**: Ensure that the `loginData.xlsx` file exists in the `src/main/resources` directory with a sheet named `sheet1` and the necessary columns (`username`, `password`, `shouldLogin`).

#### Running the Tests
- **From an IDE**: Right-click on the `LoginTest.java` file and select "Run 'LoginTest'".
- **From the command line (with Maven)**: Use `mvn test` (assuming you have a proper `pom.xml`).

#### Generating Allure Report
1. After the tests are run, navigate to your project directory in the terminal.
2. Run the command:
   ```bash
   allure serve [path_to_allure_results]
   ```
   This will generate and open the Allure report in your browser.
