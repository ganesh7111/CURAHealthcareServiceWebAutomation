# CURA Healthcare Service Web Automation

[![Java](https://img.shields.io/badge/Java-17%2B-blue)](https://java.com)
[![Selenium](https://img.shields.io/badge/Selenium-4.1.0-green)](https://selenium.dev)
[![TestNG](https://img.shields.io/badge/TestNG-7.5-red)](https://testng.org)

Automated test suite for CURA Healthcare Service web application using Selenium WebDriver and TestNG with Page Object Model pattern.

## Features
- ✅ Login/Logout functionality testing
- ✅ Appointment booking workflow
- ✅ Page navigation validation
- 🧩 Page Object Model implementation
- ⚙️ Configurable through properties file
- 🚦 TestNG parallel execution support

## Technologies
- **Core**: Java 17, Selenium 4
- **Testing**: TestNG, WebDriverManager
- **Build**: Maven
- **Pattern**: Page Object Model (POM)
- **CI/CD**: GitHub Actions (Recommended)

## Prerequisites
- Java JDK 17+
- Maven 3.8.6+
- Chrome/Firefox browsers
- Internet connection

## Installation
```bash
git clone https://github.com/ganesh7111/CURAHealthcareServiceWebAutomation.git
cd CURAHealthcareServiceWebAutomation
mvn clean install
