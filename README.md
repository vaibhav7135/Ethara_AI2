# Ethara_AI
# 🚀 Team Task Manager (Full-Stack Backend)

## 📌 Project Overview

The **Team Task Manager** is a backend system that allows users to manage projects, assign tasks, and track progress with role-based access control.

This system supports:

* Admin and Member roles
* Project creation and team management
* Task assignment and tracking
* Dashboard analytics

---

## 🛠️ Tech Stack

* Backend: Spring Boot
* Security: Spring Security + JWT
* Database: MySQL
* Build Tool: Maven

---

## 🔐 Features

### 1. Authentication

* User Signup & Login
* JWT-based authentication
* Role-based access (ADMIN / MEMBER)

---

### 2. Project Management

* Admin can create projects
* Admin assigns members to projects
* Members can view only assigned projects

---

### 3. Task Management

* Create tasks within a project
* Assign tasks to members
* Update task status (PENDING, IN_PROGRESS, COMPLETED)
* Due date support

---

### 4. Dashboard

* Total tasks
* Completed tasks
* Pending tasks
* Overdue tasks
* Project-wise and user-wise analytics

---

## 🔗 API Endpoints

### 🔐 Auth

* POST `/auth/register`
* POST `/auth/login`

### 🏢 Projects

* POST `/projects`
* GET `/projects`
* GET `/projects/my-projects/{userId}`

### 📋 Tasks

* POST `/tasks`
* PUT `/tasks/{id}/status`
* GET `/tasks/user/{userId}`

### 📊 Dashboard

* GET `/dashboard/project/{projectId}`
* GET `/dashboard/user/{userId}`

---

## ⚙️ Setup Instructions

### 1. Clone Repository

```bash
git clone https://github.com/your-username/task-manager-backend.git
cd task-manager-backend
```

### 2. Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_manager
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3. Run Application

```bash
mvn spring-boot:run
```

---

## 🚀 Deployment

* Backend deployed on Railway
* Live URL: https://your-app.up.railway.app

---

## 🎥 Demo Video

(Add your demo video link here)

---

## 👨‍💻 Author

* Vaibhav Magar

---

## ⭐ Notes

This project demonstrates:

* REST API design
* Secure authentication (JWT)
* Role-based authorization
* Real-world project & task management system
