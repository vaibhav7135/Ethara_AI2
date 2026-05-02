# 🚀 Task Manager Backend (Spring Boot + JWT)

## 📌 Project Overview

This is a **Task Management System Backend** built using **Spring Boot**, **MySQL**, and **JWT Authentication**.
It allows admins to create projects, assign members, and manage tasks with role-based access.

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot
* Spring Security (JWT)
* Spring Data JPA (Hibernate)
* MySQL (Railway Cloud DB)
* Maven
* Postman (API Testing)

---

## 🌐 Live Deployment

* 🔗 Backend URL:
  https://etharaai2-production.up.railway.app

* 🗄️ Database: MySQL (Railway)

---

## 🔐 Features

### 🔑 Authentication

* User Registration
* User Login
* Password Encryption (BCrypt)
* JWT-based Authentication

---

### 👥 Role-Based Access

* ADMIN → create projects, assign members
* MEMBER → view assigned projects & tasks

---

### 📁 Project Management

* Admin creates project
* Admin assigns members
* Members can view assigned projects

---

### 📋 Task Management

* Create task
* Assign task to member
* Update task status
* Track progress

---

### 📊 Dashboard

* Total tasks
* Completed tasks
* Pending tasks
* Overdue tasks

---

## ⚙️ API Endpoints

### 🔐 Auth APIs

#### 1. Register

POST /auth/register

```json
{
  "name": "Admin",
  "email": "admin@gmail.com",
  "password": "1234"
}
```

---

#### 2. Login

POST /auth/login

```json
{
  "email": "admin@gmail.com",
  "password": "1234"
}
```

---

### 📁 Project APIs

#### Create Project (ADMIN)

POST /projects

```json
{
  "name": "Project 1",
  "description": "Demo project",
  "adminId": 1,
  "memberIds": [2,3]
}
```

---

#### Get All Projects

GET /projects

---

#### Get My Projects

GET /projects/my

---

### 📋 Task APIs

#### Create Task

POST /tasks

```json
{
  "title": "Task 1",
  "description": "Task description",
  "projectId": 1,
  "assignedTo": 2
}
```

---

#### Get Tasks

GET /tasks

---

### 📊 Dashboard API

#### Get Dashboard Data

GET /dashboard

---

## 🔑 Authorization (IMPORTANT)

All protected APIs require JWT token.

### Add Header:

```text
Authorization: Bearer <YOUR_TOKEN>
```

---

## 🧪 How to Test (Using Postman)

1. Register a user
2. Login
3. Copy JWT token
4. Add token in Authorization header
5. Access APIs

---

## ⚠️ Notes

* Root URL (`/`) will show **403 Forbidden** → This is expected (secured app)
* Use Postman to test APIs
* Ensure DB is connected via Railway

---

## 🚀 Deployment (Railway)

1. Push code to GitHub
2. Connect repo to Railway
3. Add MySQL database
4. Set environment variables:

```properties
MYSQL_URL=jdbc:mysql://root:AUJcVhFTwbVrWhvMSWVGzRiraRVCCAEj@interchange.proxy.rlwy.net:49365/railway
MYSQLUSER=root
MYSQLPASSWORD=AUJcVhFTwbVrWhvMSWVGzRiraRVCCAEj




```

5. Deploy

---

## 📂 Project Structure

```
com.taskmanager.demo
│
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── util
```

---

## 🎯 Future Enhancements

* Frontend (React.js)
* Notifications
* File attachments
* Real-time chat

---

## 👨‍💻 Author

Vaibhav Magar
BE Computer Engineering

---

## 💬 Viva Line

“This project is a role-based task management system built using Spring Boot and JWT authentication, deployed on Railway with MySQL.”

---
