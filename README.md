# QE Automation Development Challenge

## Overview
This project is created for the Quality Engineer (Automation) challenge by Pham Thi Thu
It covers both UI Automation Testing and API Automation Testing.

---

## Tech Stack
- Java 17
- Maven
- Selenium WebDriver
- Cucumber (BDD)
- Page Object Model (POM)
- RestAssured (API Testing)

---

## Project Structure
- UI Automation: OrangeHRM Demo Site
- API Automation: GitHub REST API (SeleniumHQ organization)

---

## Setup

git clone https://github.com/helloiamthu/qe-automation-challenge.git
cd qe-automation-challenge
mvn clean install

---

## Run UI Tests

mvn test -Dtest=UITestRunner

Expected result: BUILD SUCCESS

---

## Run API Tests

mvn test -Dtest=GitHubApiTest

Expected result: 
Total open issues: <number>
Highest-rated repo: <repository-name>
BUILD SUCCESS
