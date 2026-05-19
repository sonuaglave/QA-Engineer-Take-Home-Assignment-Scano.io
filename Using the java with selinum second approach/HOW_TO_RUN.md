# How to Run the SauceDemoFlow Project

## Overview

This document provides comprehensive instructions on how to run the SauceDemoFlow test automation project using different methods and configurations.

---

## Table of Contents

1. [Quick Start](#quick-start)
2. [Prerequisites Check](#prerequisites-check)
3. [Maven Command Methods](#maven-command-methods)
4. [IDE Methods](#ide-methods)
5. [Command Line Methods](#command-line-methods)
6. [Running Specific Tests](#running-specific-tests)
7. [Test Execution Options](#test-execution-options)
8. [Viewing Test Results](#viewing-test-results)
9. [Troubleshooting](#troubleshooting)

---

## Quick Start

### Fastest Way to Run All Tests

```bash
# Navigate to project directory
cd c:\Users\Sonu\Desktop\saucedemoflow

# Run all tests
mvn clean test
```

Expected output:

- Tests compile and execute
- Browser window opens automatically
- Tests run through login, cart, and checkout scenarios
- Reports generate in `test-output/` folder
- Press any key to close browser after completion

---

## Prerequisites Check

### Step 1: Verify Java Installation

```bash
java -version
```

**Expected Output:**

```
java version "11.0.11" 2021-04-20 LTS
Java(TM) SE Runtime Environment 18.9
Java HotSpot(TM) 64-Bit Server VM
```

### Step 2: Verify Maven Installation

```bash
mvn -version
```

**Expected Output:**

```
Apache Maven 3.6.3
Maven home: C:\apache-maven-3.6.3
Java version: 11.0.11
```

### Step 3: Verify Git Installation (Optional)

```bash
git --version
```

### Step 4: Check Configuration File

Verify `src/test/resources/config.properties` exists with valid data:

```properties
br=chrome
url=https://demowebshop.tricentis.com/
username=sudar@gmail.com
userpass=Sonu5745@
```

---

## Maven Command Methods

### Method 1: Run All Tests (Standard)

```bash
mvn clean test
```

**What it does:**

- ✅ Cleans previous build artifacts
- ✅ Compiles all source code
- ✅ Runs all test classes
- ✅ Generates HTML and XML reports
- ✅ Displays summary in console

**Output Location:**

- Test Reports: `test-output/emailable-report.html`
- XML Results: `test-output/testng-results.xml`

---

### Method 2: Run Tests Without Cleaning

```bash
mvn test
```

**What it does:**

- ✅ Uses previous compiled code (faster)
- ✅ Runs all test classes
- ✅ Generates reports
- ❌ Does NOT clean previous artifacts

**Use When:** You haven't modified source code recently

---

### Method 3: Run Single Test Class

```bash
# Run only Login tests
mvn clean test -Dtest=LoginDetail

# Run only Cart tests
mvn clean test -Dtest=CartDetail

# Run only Checkout tests
mvn clean test -Dtest=CheckoutDetail
```

**Output:**

- Only selected test class executes
- Report includes only those test results

---

### Method 4: Run Specific Test Method

```bash
# Run single method from a class
mvn clean test -Dtest=LoginDetail#testValidLogin

# Run multiple specific methods
mvn clean test -Dtest=LoginDetail#testValidLogin+testInvalidLogin
```

**Use When:** You want to test one specific scenario

---

### Method 5: Run Multiple Test Classes

```bash
# Run two test classes
mvn clean test -Dtest=LoginDetail,CartDetail

# Run using wildcard pattern
mvn clean test -Dtest=*Detail
```

---

### Method 6: Run Tests with Pattern Matching

```bash
# Run all classes ending with "Detail"
mvn clean test -Dtest=*Detail

# Run all classes containing "Login"
mvn clean test -Dtest=*Login*

# Run all classes with "Test" in name
mvn clean test -Dtest=*Test*
```

---

### Method 7: Skip Tests During Build

```bash
mvn clean install -DskipTests
```

**Use When:** You only want to compile code without running tests

---

### Method 8: Run with Debug Output

```bash
# Enable verbose logging
mvn clean test -X

# Enable specific package debugging
mvn clean test -Dorg.slf4j.simpleLogger.defaultLogLevel=debug
```

---

## IDE Methods

### Using Eclipse

#### Step 1: Right-Click on Test Class

1. Open Eclipse
2. Navigate to: `src/test/java/Scanoio/`
3. Right-click on `RunTestScano.java`

#### Step 2: Select Run Option

```
Right-Click → Run As → TestNG Test
```

#### Step 3: View Results

- Results appear in TestNG Results tab
- Green checkmark = Pass
- Red X = Fail

#### Step 4: View Reports

```
Right-Click on Test Class → Show Test Report
```

---

### Using IntelliJ IDEA

#### Step 1: Open Test Class

1. Open IntelliJ IDEA
2. Navigate to: `src/test/java/Scanoio/RunTestScano.java`

#### Step 2: Run All Tests

```
Click Green Play Button (Run) → All Tests
Or: Ctrl+Shift+F10
```

#### Step 3: Run Specific Test Class

```
Right-Click on Class Name → Run 'ClassName'
```

#### Step 4: Run Single Test Method

```
Right-Click on Method → Run 'methodName'
```

#### Step 5: View Test Results

- Results appear in "Run" tab at bottom
- Click on test name to see details
- Click "Show in Explorer" to view HTML report

---

### Using Visual Studio Code

#### Step 1: Install Extensions

1. Extensions → Search "Java"
2. Install "Extension Pack for Java"
3. Install "Test Explorer UI"

#### Step 2: Open Project

```
File → Open Folder → Select saucedemoflow
```

#### Step 3: View Test Explorer

1. Click Test Explorer icon (left sidebar)
2. Expand "Scanoio" package
3. View all test classes

#### Step 4: Run Tests

```
Right-Click on Test Class → Run Tests
Or: Click Green Play Icon next to class name
```

---

## Command Line Methods

### Method 1: Using Windows Command Prompt (cmd)

```bash
# Open Command Prompt
# Press Win + R
# Type: cmd
# Press Enter

# Navigate to project
cd C:\Users\Sonu\Desktop\saucedemoflow

# Run tests
mvn clean test
```

---

### Method 2: Using PowerShell

```powershell
# Open PowerShell
# Press Win + X → Select "Windows PowerShell" or "Terminal"

# Navigate to project
cd C:\Users\Sonu\Desktop\saucedemoflow

# Run tests
mvn clean test
```

---

### Method 3: Using Git Bash

```bash
# Open Git Bash
# Right-Click in folder → Git Bash Here

# Run tests (if already in project directory)
mvn clean test

# Or navigate first
cd saucedemoflow
mvn clean test
```

---

### Method 4: Direct Execution without Maven

```bash
# First compile the project
javac -cp "lib/*;target/*" src/test/java/Scanoio/*.java

# Then run the test
java -cp "lib/*;target/*;src/test/resources" org.testng.TestNG testng.xml
```

---

## Running Specific Tests

### Run All Login Tests

```bash
mvn clean test -Dtest=LoginDetail
```

### Run Valid Login Test Only

```bash
mvn clean test -Dtest=LoginDetail#testValidLogin
```

### Run All Cart Operations

```bash
mvn clean test -Dtest=CartDetail
```

### Run Add to Cart Test Only

```bash
mvn clean test -Dtest=CartDetail#testAddToCart
```

### Run All Checkout Tests

```bash
mvn clean test -Dtest=CheckoutDetail
```

### Run Complete Order Checkout Only

```bash
mvn clean test -Dtest=CheckoutDetail#testCompleteCheckout
```

### Run Multiple Specific Tests

```bash
# Run login and cart tests
mvn clean test -Dtest=LoginDetail,CartDetail

# Run specific methods from different classes
mvn clean test -Dtest=LoginDetail#testValidLogin,CartDetail#testAddToCart
```

---

## Test Execution Options

### Option 1: Parallel Execution (Faster)

```bash
mvn clean test -DsuiteXmlFile=testng.xml -Dparallel=methods -DthreadCount=4
```

### Option 2: Sequential Execution (Default)

```bash
mvn clean test
```

### Option 3: With Custom Browser

Update `config.properties`:

```properties
br=firefox    # Change from chrome to firefox
```

Then run:

```bash
mvn clean test
```

### Option 4: Headless Mode (No GUI)

Update `config.properties`:

```properties
headless=true
```

Then run:

```bash
mvn clean test
```

### Option 5: With Increased Timeout

Update `config.properties`:

```properties
implicitly_wait=20
page_load_timeout=25
```

### Option 6: With Screenshots on Failure

Ensure BaseClass has screenshot method, then run:

```bash
mvn clean test
```

---

## Viewing Test Results

### View HTML Report (Recommended)

1. After tests complete, navigate to:
   ```
   test-output/emailable-report.html
   ```
2. Right-click → Open with Browser
3. Or double-click the file to open

### View Detailed HTML Report

```
test-output/index.html
```

### View Test Suite Report

```
test-output/Default suite/Default test.html
```

### View XML Report

```
test-output/testng-results.xml
```

### View Failed Tests (if any)

```
test-output/testng-failed.xml
```

---

## Step-by-Step Execution Guide

### Step 1: Open Terminal/Command Prompt

- **Windows:** Press `Win + R` → Type `cmd` → Press Enter
- **PowerShell:** Press `Win + X` → Select "Windows PowerShell"
- **Git Bash:** Right-click in folder → "Git Bash Here"

### Step 2: Navigate to Project

```bash
cd C:\Users\Sonu\Desktop\saucedemoflow
```

### Step 3: Verify Setup

```bash
mvn -version
java -version
```

### Step 4: Update Configuration

Edit `src/test/resources/config.properties` with valid credentials

### Step 5: Run Tests

```bash
mvn clean test
```

### Step 6: Monitor Execution

- Watch console for test progress
- See "Tests run: X, Failures: 0, Errors: 0" at end
- Browser window opens and closes automatically

### Step 7: View Results

```bash
# Open HTML report
test-output/emailable-report.html
```

---

## Common Execution Scenarios

### Scenario 1: Quick Smoke Test

Run only critical tests:

```bash
mvn clean test -Dtest=LoginDetail#testValidLogin,CartDetail#testAddToCart,CheckoutDetail#testCompleteCheckout
```

### Scenario 2: Full Regression

Run all test classes:

```bash
mvn clean test
```

### Scenario 3: Debug Failed Test

Run failed test with verbose output:

```bash
mvn clean test -Dtest=FailedTestClass -X
```

### Scenario 4: Nightly Run

Run with timeout and generate comprehensive reports:

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### Scenario 5: CI/CD Pipeline

```bash
mvn clean test -DskipTests=false -Dheadless=true
```

---

## Troubleshooting Test Execution

### Issue: "Maven command not found"

```bash
# Add Maven to system PATH or use full path
C:\apache-maven-3.6.3\bin\mvn clean test
```

### Issue: Tests hang or timeout

```bash
# Increase timeout in config.properties
implicitly_wait=30
page_load_timeout=30

# Or run with timeout parameter
mvn clean test -DtestFailureIgnore=false
```

### Issue: Browser not opening

```bash
# Ensure ChromeDriver is compatible
mvn clean install

# Or disable headless mode if enabled
# Edit config.properties: headless=false
```

### Issue: "No tests found"

```bash
# Rebuild test classes
mvn clean test-compile

# Verify test class names match pattern
# Default pattern: *Test.java or *TestCase.java
```

### Issue: Configuration file not found

```bash
# Ensure file exists at correct location
src/test/resources/config.properties

# Rebuild to refresh classpath
mvn clean compile
```

---

## Best Practices When Running Tests

✅ **Before Execution:**

- [ ] Update config.properties with valid credentials
- [ ] Ensure target URL is accessible
- [ ] Close other browser instances
- [ ] Check internet connection
- [ ] Run `mvn clean install` first time

✅ **During Execution:**

- [ ] Don't interact with browser
- [ ] Keep terminal/IDE visible
- [ ] Monitor console for errors
- [ ] Don't close IDE or terminal

✅ **After Execution:**

- [ ] Review test report
- [ ] Check pass/fail counts
- [ ] Document any failures
- [ ] Analyze error messages
- [ ] Take screenshots if available

---

## Performance Tips

```bash
# Run tests in parallel (faster)
mvn clean test -DthreadCount=4 -Dparallel=methods

# Skip Maven cleanup (faster for repeated runs)
mvn test

# Skip test compilation (if not modified)
mvn test -Dtest=LoginDetail

# Generate minimal output
mvn test -q
```

---

## Environment Variables

```bash
# Set Java Home (if needed)
set JAVA_HOME=C:\Program Files\Java\jdk-11

# Set Maven Home (if needed)
set MAVEN_HOME=C:\apache-maven-3.6.3

# Add to PATH (permanent via System Properties)
# Control Panel → System → Environment Variables → New
```

---

## Summary of Commands

| Command                                            | Purpose                     |
| -------------------------------------------------- | --------------------------- |
| `mvn clean test`                                   | Run all tests (recommended) |
| `mvn test`                                         | Run tests without clean     |
| `mvn clean test -Dtest=LoginDetail`                | Run single test class       |
| `mvn clean test -Dtest=LoginDetail#testValidLogin` | Run single test method      |
| `mvn clean install -DskipTests`                    | Compile without testing     |
| `mvn clean test -X`                                | Run with debug output       |
| `mvn dependency:tree`                              | View dependencies           |
| `mvn clean site`                                   | Generate site documentation |

---

**Last Updated:** May 20, 2026  
**Project:** SauceDemoFlow  
**Framework:** Selenium + TestNG + Maven
