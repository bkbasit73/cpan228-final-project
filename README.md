# Event Booking System

Final group project for **CPAN-228 Web Application Development** at **Humber Polytechnic**.

This application is a **Spring Boot web application** that allows users to browse and create events with a secure login system and role-based access control.

The system demonstrates modern web development using **Spring Boot, Spring Security, Thymeleaf, and Spring Data JPA**.

---

# Technologies Used

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* Thymeleaf
* H2 Database
* Bootstrap
* Maven
* Git & GitHub

---

# Features

* User registration
* Secure login system
* Password encryption using **BCrypt**
* Role-based access control
* Admin user management
* Event creation and viewing
* Responsive UI using Bootstrap
* Database persistence using H2

---

# User Roles

The application includes three roles:

| Role      | Permissions                          |
| --------- | ------------------------------------ |
| ADMIN     | Manage users and access all features |
| ORGANIZER | Create and manage events             |
| USER      | View events                          |

---

# Test Accounts

These accounts can be used to test the system.

Admin
Username: `admin`
Password: `admin123`

Organizer
Username: `organizer`
Password: `organizer123`

User
Username: `user`
Password: `user123`

---

# How to Run the Application

### 1 Clone the Repository

```bash
git clone https://github.com/your-username/cpan228-final-project.git
```

### 2 Go to the Project Folder

```bash
cd cpan228-final-project
```

### 3 Run the Application Using Maven

```bash
./mvnw spring-boot:run
```

If you are using Windows PowerShell:

```bash
mvnw.cmd spring-boot:run
```

### 4 Open the Application

Open your browser and go to:

```
http://localhost:8080
```

---

# Run from VS Code

1. Open the project in **VS Code**
2. Locate the file:

```
Cpan228finalprojectApplication.java
```

3. Click **Run**
4. Open browser:

```
http://localhost:8081
```

---

# H2 Database Console

You can view the database in the browser.

```
http://localhost:8080/h2-console
```

Use the following settings:

JDBC URL

```
jdbc:h2:file:./data/testdb
```

Username

```
sa
```

Password

```
(empty)
```

---

# Security Implementation

The application uses **Spring Security** with the following features:

* BCrypt password encryption
* Role-based authorization
* Secure login and logout
* Protected routes for ADMIN and ORGANIZER roles

Example security rules:

* `/admin/**` → ADMIN only
* `/events/new` → ADMIN and ORGANIZER

---

# Project Structure

```
src
 ├─ main
 │   ├─ java
 │   │   ├─ config
 │   │   ├─ controller
 │   │   ├─ model
 │   │   ├─ repository
 │   │   └─ service
 │   └─ resources
 │       ├─ templates
 │       ├─ static
 │       └─ application.properties
```

---

# Screenshots

(Add screenshots here if desired)

Example:

```
docs/home.png
docs/admin.png
docs/login.png
```

---

# Author

Group 2
Abdul Basit
Davinder Kehal
Maryan Farah

Computer Programming & Analysis
Humber Polytechnic
