# CarRental-University

A modular, object-oriented **Car Rental System** built in Java with Swing GUI, implementing advanced software architecture and design patterns. Developed as part of a second-year Software Engineering course, the system demonstrates real-world engineering practices using Java SE.

---

## Overview

This project simulates a real-world **Car Rental Management System** with separate roles for customers and administrators. It includes features such as:

- Vehicle browsing and filtering
- Customer registration and login with verification
- Reservation and dynamic pricing logic
- Admin dashboard for managing cars and users
- Integrated design patterns for scalable, maintainable architecture

The graphical user interface is built using **Java Swing**, and the backend logic is structured with **OOP principles** and **software design patterns** for flexibility and reusability.

---

## Technologies & Tools

- **Language:** Java SE 17  
- **GUI:** Swing  
- **IDE:** IntelliJ IDEA / Eclipse  
- **Version Control:** Git, GitHub  
- **Design Methodology:** Agile (Scrum)  
- **Design Tools:** PlantUML, draw.io (for UML Diagrams)

---

## Key Features

| Module              | Description |
|---------------------|-------------|
| Vehicle Listing   | Display and iterate through available cars |
| Authentication    | Login, register, and role-based access control |
| Reservation       | Create rental bookings with custom pricing |
| Admin Panel       | Add/edit/remove vehicles, view bookings |
| Logs              | System logging and audit trails |
| GUI               | Desktop interface using Java Swing |

---

## Applied Design Patterns

| Pattern      | Application |
|--------------|-------------|
| **Factory**  | Dynamically instantiate user roles (Admin, Customer) |
| **Proxy**    | Control access to admin-only features |
| **Observer** | Trigger events like SMS verification or logging |
| **Builder**  | Flexible reservation object creation |
| **Decorator**| Add optional services (insurance, GPS) to car |
| **Iterator** | Navigate car listings |
| **Strategy** | Apply different pricing models (weekend/weekday) |
| **Visitor**  | Perform logging and inspection without changing object structure |
| **Bridge**   | Abstract payment gateways (Stripe/PayPal) – for future integration |

---

## Agile Development Process

We followed **Scrum** methodology throughout the development process.

### Sprint Structure

| Sprint | Focus Area |
|--------|------------|
| Sprint 1 | Vehicle listing module + Iterator pattern |
| Sprint 2 | SMS Verification + Observer pattern |
| Sprint 3 | Reservation & Pricing + Strategy/Builder patterns |
| Sprint 4 | Admin Control Panel + Factory/Proxy patterns |
| Sprint 5 | Logs & Audits + Visitor pattern |
| Sprint 6 | Code review, testing, and final deployment |

---

## Testing

- **Unit Testing:** Reservation, pricing logic  
- **Manual Testing:** GUI features, user roles  
- **Integration Testing:** Login → Reserve → Admin workflows  
- **Code Quality:** Applied SOLID principles, encapsulation, and design patterns  

---

## Folder Structure

```

CarRental-University/
├── src/
│   ├── models/
│   ├── gui/
│   ├── controllers/
│   ├── patterns/
│   ├── main/
├── diagrams/
├── screenshots/
└── README.md

````

---

## How to Run

1. Clone the repository  
```bash
git clone https://github.com/AboudEy96/CarParking-University.git
````

2. Open with your preferred Java IDE (IntelliJ/Eclipse)

3. Run `Main.java` from the `main` package

4. Interact via the Java Swing GUI

---

## Contact

* **Abdulkadir** [GitHub](https://github.com/AboudEy96/) • [Twitter](https://x.com/AboudEy96)
 
* **Moustafa Mohamed**
[LinkedIn](https://www.linkedin.com/in/moustafamohamed01/) • [GitHub](https://github.com/MoustafaMohamed01) • [Kaggle](https://www.kaggle.com/moustafamohamed01)
