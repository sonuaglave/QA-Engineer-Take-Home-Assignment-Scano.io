# SauceDemoFlow - Test Automation Framework

## Project Overview

**SauceDemoFlow** is a comprehensive Selenium WebDriver-based test automation framework designed for end-to-end testing of web applications. Built with TestNG for test execution and Maven for dependency management, this project provides automated testing for user authentication, shopping cart operations, and checkout processes.

---

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Installation](#installation)
3. [Configuration](#configuration)
4. [Project Structure](#project-structure)
5. [Running Tests](#running-tests)
6. [Test Reports](#test-reports)
7. [Troubleshooting](#troubleshooting)
8. [IDE Setup](#ide-setup)
9. [Additional Resources](#additional-resources)

---

## Prerequisites

### System Requirements

- **Operating System:** Windows 10/11, macOS, or Linux
- **RAM:** Minimum 4GB (8GB recommended)
- **Disk Space:** 500MB minimum

### Required Software

#### Java Development Kit (JDK)

- **Version:** JDK 8 or higher (JDK 11+ recommended)
- **Download:** https://www.oracle.com/java/technologies/downloads/
- **Installation Guide:**
  - Windows: Run installer and follow on-screen instructions
  - macOS: Use Homebrew: `brew install openjdk`
  - Linux: `sudo apt-get install openjdk-11-jdk`
- **Verify Installation:**
  ```bash
  java -version
  ```

#### Apache Maven

- **Version:** 3.6.0 or higher
- **Download:** https://maven.apache.org/download.cgi
- **Installation:**
  - Extract Maven to a folder (e.g., `C:\Program Files\maven`)
  - Add Maven `bin` folder to system PATH
- **Verify Installation:**
  ```bash
  mvn -version
  ```

#### Git (Optional)

- **Download:** https://git-scm.com/
- **Useful for version control and cloning the project**

#### Google Chrome Browser

- **Version:** Latest stable version
- **Download:** https://www.google.com/chrome/
- **Note:** ChromeDriver is managed automatically by Maven

---

## Installation

### Step 1: Clone or Extract Project

```bash
# Navigate to desired directory
cd C:\Users\YourUsername\Desktop

# Clone the repository (if using Git)
git clone <repository-url>

# Or extract the ZIP file to saucedemoflow folder
cd saucedemoflow
```

### Step 2: Verify Java and Maven Installation

```bash
# Check Java version
java -version

# Check Maven version
mvn -version
```

### Step 3: Install Project Dependencies

```bash
# Navigate to project root directory
cd saucedemoflow

# Download and install all dependencies
mvn clean install
```

This command will:

- Clean previous build artifacts
- Download all Maven dependencies
- Compile the project
- Download ChromeDriver automatically

---

## Configuration

### Step 1: Locate Configuration File

The configuration file is located at:

```
src/test/resources/config.properties
```

### Step 2: Update Configuration Properties

Open `config.properties` and update the following:

```properties
# Browser Configuration
br=chrome                                    # Browser type (chrome, firefox, edge, safari)

# Application URL
url=https://demowebshop.tricentis.com/     # Target application URL

# Test Credentials
username=sudar@gmail.com                    # Valid test user email
userpass=Sonu5745@                          # Corresponding password

# Optional: Headless Mode (set to true to run without GUI)
headless=false

# Optional: Implicit Wait (in seconds)
implicitly_wait=10

# Optional: Page Load Timeout (in seconds)
page_load_timeout=15
```

### Step 3: Verify Configuration

Ensure all values are correctly set before running tests. Invalid credentials or URLs will cause test failures.

---

## Project Structure

```
saucedemoflow/
│
├── src/
│   ├── main/
│   │   ├── java/                          # Main application code
│   │   └── resources/                     # Main resources
│   │
│   └── test/
│       ├── java/
│       │   └── Scanoio/
│       │       ├── BaseClass.java         # Base test class with setup/teardown
│       │       ├── LoginDetail.java       # Login test scenarios
│       │       ├── CartDetail.java        # Shopping cart tests
│       │       ├── CheckoutDetail.java    # Checkout process tests
│       │       └── RunTestScano.java      # Main test runner
│       │
│       └── resources/
│           └── config.properties          # Test configuration file
│
├── target/                                # Build output directory (auto-generated)
│   ├── classes/                           # Compiled classes
│   └── test-classes/                      # Compiled test classes
│
├── test-output/                           # TestNG reports (auto-generated)
│   ├── emailable-report.html              # Email-friendly report
│   ├── index.html                         # Main HTML report
│   └── testng-results.xml                 # XML results
│
├── pom.xml                                # Maven project configuration
├── README.md                              # Project documentation
├── TEST_CASES.md                          # Test case documentation
└── BUG_REPORT.md                          # Bug tracking document
```

### Key Java Classes

| Class                   | Purpose                                                                                                                                 |
| ----------------------- | --------------------------------------------------------------------------------------------------------------------------------------- |
| **BaseClass.java**      | Contains @BeforeSuite, @BeforeTest, @BeforeMethod for setup; @AfterMethod, @AfterTest, @AfterSuite for teardown; Common utility methods |
| **LoginDetail.java**    | Test methods for user login scenarios (valid/invalid credentials)                                                                       |
| **CartDetail.java**     | Test methods for shopping cart operations (add, update, remove items)                                                                   |
| **CheckoutDetail.java** | Test methods for checkout process and order completion                                                                                  |
| **RunTestScano.java**   | Entry point; executes all test classes; main() method for direct execution                                                              |

---

## Running Tests

### Option 1: Run All Tests (Recommended)

```bash
mvn clean test
```

- Cleans previous builds
- Compiles all code
- Executes all test classes
- Generates test report

### Option 2: Run Specific Test Class

```bash
# Run only LoginDetail tests
mvn clean test -Dtest=LoginDetail

# Run only CartDetail tests
mvn clean test -Dtest=CartDetail

# Run only CheckoutDetail tests
mvn clean test -Dtest=CheckoutDetail
```

### Option 3: Run Specific Test Method

```bash
# Run specific method from a test class
mvn clean test -Dtest=LoginDetail#testValidLogin

mvn clean test -Dtest=CartDetail#testAddToCart

mvn clean test -Dtest=CheckoutDetail#testCheckout
```

### Option 4: Run Multiple Specific Tests

```bash
# Run multiple test methods
mvn clean test -Dtest=LoginDetail,CartDetail

# Run with pattern
mvn clean test -Dtest=*Detail
```

### Option 5: Skip Tests During Build

```bash
mvn clean install -DskipTests
```

### Option 6: Run Tests with Different Browser

Update `config.properties` with desired browser and run:

```bash
mvn clean test
```

### Option 7: Run with Custom Log Level

```bash
# Enable debug logging
mvn clean test -X

# Enable info logging
mvn clean test
```

---

## Test Reports

### Accessing Reports

After test execution, reports are generated in the `test-output/` directory:

#### 1. HTML Report (Recommended)

```
test-output/emailable-report.html
test-output/index.html
test-output/Default suite/Default test.html
```

- Open in any web browser
- Includes pass/fail status, execution time, screenshots

#### 2. XML Report

```
test-output/testng-results.xml
test-output/testng-failed.xml (if failures)
```

- Machine-readable format
- Use for CI/CD pipeline integration

#### 3. Maven Surfire Report

```
target/surefire-reports/
```

- Standard Maven test reports
- Includes test execution details

### Report Details Include:

- ✅ Test execution summary
- ✅ Individual test results with execution time
- ✅ Pass/Fail status
- ✅ Error messages and stack traces
- ✅ Screenshots (if configured)
- ✅ Execution date and duration

---

## Troubleshooting

### Issue 1: `java -version` command not found

**Cause:** Java not installed or PATH not configured
**Solution:**

1. Install JDK from oracle.com
2. Add JDK bin folder to system PATH
3. Restart terminal/IDE
4. Verify: `java -version`

### Issue 2: `mvn -version` command not found

**Cause:** Maven not installed or PATH not configured
**Solution:**

1. Download Maven from maven.apache.org
2. Extract to a folder (e.g., C:\maven)
3. Add Maven bin folder to system PATH
4. Restart terminal/IDE
5. Verify: `mvn -version`

### Issue 3: Build fails with "No compiler found"

**Cause:** JDK not properly configured
**Solution:**

```bash
# Set JAVA_HOME environment variable
# Windows: setx JAVA_HOME "C:\Program Files\Java\jdk-11"
# Linux/Mac: export JAVA_HOME=/usr/lib/jvm/java-11-openjdk

mvn clean compile
```

### Issue 4: Tests cannot find config.properties

**Cause:** File location incorrect or not on classpath
**Solution:**

1. Ensure file exists at: `src/test/resources/config.properties`
2. Rebuild project:
   ```bash
   mvn clean compile
   ```
3. Check file encoding is UTF-8

### Issue 5: ChromeDriver not found or version mismatch

**Cause:** Incompatible Chrome/ChromeDriver versions
**Solution:**

```bash
# Rebuild to fetch compatible ChromeDriver
mvn clean install

# Or manually specify Chrome version:
mvn clean test -Dwebdriverchromium.version=120
```

### Issue 6: Login fails with "Invalid credentials"

**Cause:** Wrong username/password in config.properties
**Solution:**

1. Verify username: `sudar@gmail.com`
2. Verify password: `Sonu5745@`
3. Ensure no extra spaces in config file
4. Check credentials are still valid on application

### Issue 7: Connection timeout to test URL

**Cause:** Network issue or URL not accessible
**Solution:**

1. Check internet connection: `ping google.com`
2. Verify URL is correct in config.properties
3. Try accessing URL in browser manually
4. Check if firewall blocks access
5. Increase timeout in BaseClass

### Issue 8: Tests pass individually but fail together

**Cause:** Test data/session not properly cleaned between tests
**Solution:**

1. Ensure @BeforeMethod clears cookies/cache
2. Use @BeforeSuite for one-time setup
3. Check test execution order

---

## IDE Setup

### Using Eclipse

#### Step 1: Import Project

1. Open Eclipse
2. File → Import
3. Select "Existing Maven Projects"
4. Browse to project folder
5. Click Finish

#### Step 2: Configure TestNG

1. Help → Eclipse Marketplace
2. Search for "TestNG"
3. Install TestNG for Eclipse
4. Restart Eclipse

#### Step 3: Run Tests

1. Right-click on test class
2. Run As → TestNG Test
3. View results in TestNG Results tab

### Using IntelliJ IDEA

#### Step 1: Open Project

1. File → Open
2. Select saucedemoflow folder
3. Click OK
4. IntelliJ will detect pom.xml and configure automatically

#### Step 2: Run Tests

1. Right-click on test class
2. Run 'ClassName'
3. Or press Ctrl+Shift+F10 (Windows) / Cmd+Shift+R (Mac)

#### Step 3: View Reports

1. After execution, click "Test" tab
2. Right-click on results
3. Select "Show in Explorer" to view HTML reports

### Using Visual Studio Code

#### Step 1: Install Extensions

1. Install "Extension Pack for Java"
2. Install "Maven for Java"
3. Install "Test Explorer UI"

#### Step 2: Open Project

1. File → Open Folder
2. Select saucedemoflow folder

#### Step 3: Run Tests

1. Open test class
2. Click "Run Test" above class name
3. View results in Terminal

---

## Additional Maven Commands

```bash
# Clean build artifacts
mvn clean

# Compile code only
mvn compile

# Compile test code only
mvn test-compile

# Run all tests
mvn test

# Install to local repository (without running tests)
mvn install -DskipTests

# Generate project documentation
mvn site

# Display project dependency tree
mvn dependency:tree

# Check for dependency updates
mvn versions:display-dependency-updates

# Run with specific profiles (if configured)
mvn clean test -Pprofile-name

# Check for plugin updates
mvn versions:display-plugin-updates
```

---

## Best Practices

✅ **Before Running Tests:**

- [ ] Update config.properties with valid credentials
- [ ] Ensure target URL is accessible
- [ ] Verify browser is installed and updated
- [ ] Run `mvn clean install` after pulling latest code

✅ **During Test Execution:**

- [ ] Don't interact with browser while tests run
- [ ] Keep network stable
- [ ] Monitor system resources (RAM/CPU)

✅ **After Test Execution:**

- [ ] Review test reports
- [ ] Log any failures or issues
- [ ] Update test cases if application changes
- [ ] Commit code and reports to version control

---

## Contact & Support

For issues, questions, or improvements:

1. Check this README and BUG_REPORT.md
2. Review TEST_CASES.md for test details
3. Check application logs in target/
4. Contact the development team

---

## Version History

| Version | Date         | Changes                                                    |
| ------- | ------------ | ---------------------------------------------------------- |
| 1.0     | May 20, 2026 | Initial project setup with Login, Cart, and Checkout tests |

---

**Last Updated:** May 20, 2026  
**Framework:** Selenium WebDriver + TestNG  
**Build Tool:** Apache Maven  
**Test Environment:** https://demowebshop.tricentis.com/
