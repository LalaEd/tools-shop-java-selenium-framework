# 🧪 Tools Shop Selenium Framework

![Java](https://img.shields.io/badge/Java-21-blue)
![Maven](https://img.shields.io/badge/Maven-3.9+-brightgreen)
![Selenium](https://img.shields.io/badge/Selenium-4.35+-orange)
![TestNG](https://img.shields.io/badge/TestNG-7.11+-red)

A **Selenium + Java + TestNG automation framework** built with **Maven**.  
Designed with **Page Object Model (POM)**, JSON-based test data, and built-in HTML reports for maintainable and reproducible automated tests.

---

## 🚀 Features
- Modular **Page Object Model (POM)** design  
- TestNG integration with suite files and test groups  
- JSON-based test data for flexibility  
- Multi-browser support: Chrome, Firefox, Edge  
- Built-in reporting: TestNG HTML reports and Maven Surefire reports  
- CI/CD ready (GitHub Actions, Jenkins)

---

## 📂 Project Structure

tools-shop-selenium-framework/
├── pom.xml # Maven dependencies and build configuration
├── README.md # Project documentation
├── LICENSE # MIT License
├── .gitignore # Prevents pushing sensitive/generated files
├── src/
│ ├── main/java/ # Base classes, utilities
│ └── test/
│ ├── java/
│ │ ├── pages/ # Page Object classes
│ │ └── tests/ # Test classes
│ └── resources/
│ ├── testng.xml # TestNG suite configuration
│ └── testData.json # Dummy test data
└── target/ # Maven build output (excluded from Git)


## ⚙️ Tech Stack

| Tool | Version | Purpose |
|------|---------|---------|
| Java | 21      | Programming language |
| Maven | 3.9+   | Build & dependency management |
| Selenium | 4.35+ | Browser automation |
| TestNG | 7.11+ | Test execution & reporting |
| JSON-Simple | 1.1.1 | Test data handling |
| JavaFaker | 1.0.2 | Dummy test data generation |

---

## 🧪 Quick Start

1. Clone the repository
```bash
git clone https://github.com/yourusername/tools-shop-selenium-framework.git
cd tools-shop-selenium-framework


2. Run all tests
mvn clean test

3. Run a specific TestNG suite
mvn test -DsuiteXmlFile=src/test/resources/testng.xml

4. Generate Maven Surefire report
mvn clean test site

##🧾 Test Data

Stored in src/test/resources/testData.json

Contains only dummy data for testing



