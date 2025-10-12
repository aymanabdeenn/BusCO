# 🚌 Online Bus Ticketing System

A Java MVC web application for managing and purchasing bus tickets for both **city** and **inter-city** travel.  
Developed using **Java Servlets**, **JSP**, and a **relational database** (MySQL or PostgreSQL), this system follows the **MVC architecture** and applies key **object-oriented design patterns** for modularity and scalability.

---

## 📌 Project Overview

The Online Bus Ticketing System allows **passengers** to register, search trips, estimate fares, and purchase tickets online, while **administrators** can manage trips, configure fares, and view system-wide reports.

This project emphasizes **clean architecture**, **object-oriented principles**, and **design pattern integration** (Strategy, Factory, Singleton).

---

## 👥 User Roles

### 🧍 Passenger
- Register and log in.
- Search for available trips.
- Estimate fares before purchase.
- Purchase tickets online.
- View ticket purchase history.

### 👨‍💼 Admin
- Add, update, and delete trips.
- Configure fare rules (base fares and discounts).
- View system reports (sales, revenue, tickets sold).

---

## 🎟️ Ticket Types

| Ticket Type | Description |
|--------------|--------------|
| One-Trip     | Single journey ticket |
| Daily Pass   | Unlimited city/inter-city trips within one day |
| Weekly Pass  | Unlimited trips within a week |
| Monthly Pass | Unlimited trips within a month |

Each ticket can be issued for:
- **City Travel**
- **Inter-City Travel**

---

## 💰 Fare Categories

| Category | Discount |
|-----------|-----------|
| Regular | No discount |
| Student | 20% discount |
| Senior | 30% discount |
| Evening Fare | 15% discount (One-Trip only, after 7 PM) |

🧮 **Discount Cap:**  
Total combined discounts cannot exceed **50%** of the base fare.

---

## 🗃️ Database Design

The system uses a **relational database** (e.g., MySQL or PostgreSQL) to persist:

- **Users** (passengers and admins)
- **Trips** (origin, destination, time, travel type)
- **Tickets** (type, fare, purchase details)
- **Fare Rules** (base fares and discounts)
- **Ticket Purchases** (history)

---

## 🧠 Design Patterns Used

### 🧩 Strategy Pattern – Fare Calculation
Implements dynamic fare calculation logic based on:
- Ticket type (e.g., daily, one-trip)
- Travel type (city/inter-city)
- User category (student, senior)
- Time-based discounts (evening fares)

> The correct fare strategy is selected **at runtime**, ensuring flexible pricing logic.

---

### 🏭 Factory Pattern – Ticket Creation
Uses a factory class to instantiate appropriate ticket objects based on:
- Travel type (city / inter-city)
- Ticket type (one-trip, daily, weekly, monthly)

> The factory retrieves fare configurations and returns a ticket object with accurate pricing.

---

### ⚙️ Singleton Pattern – Fare Configuration
The `FareConfig` class:
- Loads fare settings (base fares, discounts) **once** at application startup.
- Provides a global access point for consistent fare reference across the system.
- Loads data from **web.xml** or the database.

---

## 🔐 Session & History Management

- User sessions are managed using **HttpSession**.
- Recent ticket purchases are stored temporarily in session.
- Full ticket history is stored in the database and viewable by the user.
- Admin sessions provide access to management and reporting functions.

---

## 🚍 Main Use Cases

### 1. **User Registration and Login**
- Passengers can sign up and log in.
- Admins log in through a separate admin interface.
- Sessions managed with HttpSession.

### 2. **Search Available Trips**
- Filter by origin, destination, travel type, and date.
- View trip availability, departure, and arrival times.

### 3. **Fare Estimation**
- Estimate ticket cost based on trip details, ticket type, user category, and time.
- Uses the **Strategy Pattern** for dynamic fare logic.

### 4. **Purchase Ticket**
- Select a trip and ticket type.
- Apply relevant discounts.
- Ticket object created via **Factory Pattern**.
- Purchase stored in the database.

### 5. **View Purchased Tickets**
- Users can view all past ticket purchases with details (trip, fare, date).

### 6. **Admin: Manage Trips**
- Add, update, or delete bus trips and schedules.

### 7. **Admin: Configure Fare Rules**
- Update fare rules and discounts.
- Changes reflected dynamically via **Singleton FareConfig**.

### 8. **Admin: View Reports**
- View total tickets sold.
- Filter by date range, ticket type, or user category.
- Generate revenue summaries (daily, weekly, monthly).

### 9. **Logout**
- Ends the user session and returns to login/home page.

---

## 💾 Technologies Used

| Category | Technologies |
|-----------|--------------|
| Language | Java (JDK 17+) |
| Framework | Java Servlets, JSP |
| Database | MySQL / PostgreSQL |
| Architecture | MVC (Model–View–Controller) |
| Design Patterns | Strategy, Factory, Singleton |
| Tools | Apache Tomcat, JDBC |
| IDE | Eclipse / IntelliJ IDEA |
| Version Control | Git & GitHub |

---

## ⚙️ Setup & Installation

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/yourusername/OnlineBusTicketingSystem.git
2️⃣ Install MySQL Server
Download and install MySQL Server from MySQL Downloads.

Create a new database (e.g., bus_ticketing_db).

Import the provided SQL schema (if available).

🧩 Note:
The MySQL JDBC driver (mysql-connector-j-9.3.0.jar) is already included inside the project’s /lib folder — you do not need to download it separately.

3️⃣ Configure Database Connection
Update your database credentials in your configuration file (e.g., web.xml or DBConnection.java):

xml
Copy code
<context-param>
    <param-name>dbURL</param-name>
    <param-value>jdbc:mysql://localhost:3306/bus_ticketing_db</param-value>
</context-param>
<context-param>
    <param-name>dbUser</param-name>
    <param-value>root</param-value>
</context-param>
<context-param>
    <param-name>dbPassword</param-name>
    <param-value>your_password_here</param-value>
</context-param>
4️⃣ Install Apache Tomcat
Download Apache Tomcat (version 10.x or later) from Tomcat Downloads.

Add it to your IDE:

In Eclipse → Window → Preferences → Server → Runtime Environments → Add → Apache Tomcat → Browse to Tomcat directory.

In IntelliJ IDEA → File → Settings → Build, Execution, Deployment → Application Servers → Add Tomcat Server.

5️⃣ Deploy the Application
Deploy the .war file to Tomcat or run directly from your IDE.

Start the server.

6️⃣ Access the Application
Passenger Interface → http://localhost:8080/BusTicketingSystem/

Admin Interface → http://localhost:8080/BusTicketingSystem/admin

🧾 Reporting Features
Total tickets sold by date range

Revenue per day/week/month

Ticket sales by category or type

Admin dashboard view

⚠️ Business Logic Rules
Evening fares apply only to One-Trip tickets after 7 PM.

Total discount cannot exceed 50%.

City and Inter-City tickets are purchased separately.

Seat overbooking is prevented using thread synchronization.

📅 Project Details
Course Project Type: Group (3–4 students)

Deadline: May 24th, 2025

Technology Stack: Java MVC, JSP, Servlets, MySQL

Design Emphasis: Object-Oriented Programming + Design Patterns

