# Live Campus HelpDesk

## Overview

Live Campus HelpDesk is a Spring Boot based web application designed to streamline issue reporting and resolution within a college campus. Students can submit help desk tickets, while administrators can monitor, manage, and update ticket statuses through an admin dashboard.

The application provides real-time ticket updates using WebSocket technology, ensuring that students and administrators receive the latest information without manually refreshing the page.

---

## Features

- Student ticket submission portal
- Admin dashboard for ticket management
- Create, view, update, and delete tickets
- Real-time ticket updates using WebSockets
- Ticket status tracking (Pending / Resolved)
- Live statistics dashboard
- MySQL database integration
- Responsive and user-friendly interface

---

## Technologies Used

- Java 17
- Spring Boot 3
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MySQL
- WebSocket (STOMP + SockJS)
- HTML
- CSS
- JavaScript
- Maven

---

## Project Architecture

Frontend
- Thymeleaf Templates
- HTML/CSS
- JavaScript

Backend
- Spring Boot
- REST APIs
- Service Layer
- Repository Layer

Database
- MySQL

Real-Time Communication
- WebSocket
- STOMP
- SockJS

---

## Ticket Workflow

1. Student submits an issue.
2. Ticket is stored in MySQL database.
3. Default ticket status is set to PENDING.
4. Admin views all submitted tickets.
5. Admin updates ticket status.
6. Changes are instantly reflected across connected clients through WebSocket communication.

---

## REST API Endpoints

### Add Ticket
POST /tickets

### Get All Tickets
GET /tickets

### Update Ticket Status
PUT /tickets/{id}?status=RESOLVED

### Delete Ticket
DELETE /tickets/{id}

---

## Database Configuration

Update the following properties in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/helpdesk_db
spring.datasource.username=root
spring.datasource.password=your_password
```

---

## How to Run

### Clone Repository

```bash
git clone https://github.com/your-username/LiveCampusHelpDesk.git
```

### Navigate to Project

```bash
cd LiveCampusHelpDesk
```

### Create Database

```sql
CREATE DATABASE helpdesk_db;
```

### Run Application

```bash
mvn spring-boot:run
```

Application will start on:

```text
http://localhost:8080
```

---

## Screens

### Student Portal
- Submit help desk tickets
- View live ticket updates
- Track issue status

### Admin Dashboard
- View all tickets
- Update ticket status
- Delete tickets
- Monitor live statistics

---

## Future Enhancements

- User authentication and authorization
- Email notifications
- Priority-based ticket handling
- File attachment support
- Search and filter tickets
- Dashboard analytics and reporting

---

## Author

Anurag Udapure

Spring Boot | Java | Full Stack Development
