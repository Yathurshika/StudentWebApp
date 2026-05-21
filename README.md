# 🎓 Student Management System

A full-stack Java web application built using **Servlets, JDBC, MySQL, HTML, and Bootstrap**.  
This system allows administrators to manage student records with full CRUD functionality.

---

## 🚀 Features

- ✅ Admin Login System
- ➕ Add Student
- 📋 View Students
- ✏️ Update Student Details
- 🗑 Delete Student
- 📊 Total Students Counter Dashboard
- 🎨 Responsive Bootstrap UI

---

## 🛠️ Technologies Used

- Java (Servlets)
- JDBC
- MySQL Database
- HTML5
- CSS3 / Bootstrap 5
- Apache Tomcat Server

---

## 📸 Screenshots

### 🔐 Login Page
![Login Page](screenshots/login.png)

### 📊 Dashboard
![Dashboard](screenshots/dashboard.png)

### ➕ Add Student
![Add Student](screenshots/addstudent.png)

### 📋 View Students
![View Students](screenshots/viewstudents.png)

---

## ⚙️ Project Setup Guide

### 1️⃣ Install Required Tools

- Java JDK 8+
- Eclipse / NetBeans / IntelliJ
- Apache Tomcat 9+
- MySQL Server
- Git (optional)

---

### 2️⃣ Create Database

Run this SQL in MySQL:

```sql
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    course VARCHAR(100)
);
