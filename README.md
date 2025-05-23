# CarParking-University

A modular Java application developed as a university project to simulate the core components of a car parking management system. This project follows **Object-Oriented Design (OOD)** principles and leverages well-known **software design patterns** to ensure modularity, scalability, and maintainability.

---

## Overview

The `CarParking-University` system provides the foundation for managing user roles and basic vehicle entities. While minimal in features by design, it establishes a solid structure to build a fully functional car parking system by integrating user authentication, vehicle management, and admin control panels.

---

## Technologies Used

* **Language**: Java
* **Architecture**: Modular OOP
* **Design Patterns**:

  * Factory Pattern
  * Proxy Pattern (scaffolded)

---

## Project Structure

```plaintext
CarParking-University/
├── src/
│   ├── Main.java                     # Application entry point
│   ├── Entity/
│   │   ├── Customer.java             # Customer-specific implementation
│   │   ├── Admin/
│   │   │   ├── Admin.java            # Admin-specific implementation
│   │   │   └── Panel/
│   │   │       ├── AdminPanel.java         # Admin panel interface
│   │   │       ├── AdminPanelProxy.java    # Proxy class for admin access
│   │   │       └── RealAdminPanel.java     # Actual admin panel (unimplemented)
│   │   └── User/
│   │       ├── User.java             # Abstract base class for users
│   │       └── UserFactory.java      # Factory pattern implementation
│   └── Vehcile/
│       └── Vehcile.java              # Vehicle entity (typo noted)
└── CarParking.iml
```

---

## Features

* **User Abstraction**: Abstract `User` class provides a shared interface for role-specific subclasses.
* **Factory Pattern**: `UserFactory` dynamically instantiates users based on their role (`Admin`, `Customer`).
* **Proxy Pattern (Planned)**: `AdminPanelProxy` designed to manage secure access to admin operations.
* **Encapsulation**: Private attributes with public getter/setter methods for safe data handling.
* **Extensibility**: Designed to allow integration of parking slots, billing, time tracking, and databases.

---

## Getting Started

### Requirements

* Java SDK 17 or later
* IDE such as IntelliJ IDEA or Eclipse

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/AboudEy96/CarParking-University.git
   cd CarParking-University
   ```

2. Open the project in your IDE.

3. Run `Main.java` to execute the sample scenario.

---

## Design Patterns In Detail

### Factory Pattern

Implemented via `UserFactory`, this pattern decouples user object creation from the client code.

```java
User admin = UserFactory.createUser("Admin");
```

### Proxy Pattern (Planned)

`AdminPanelProxy` is scaffolded to intercept and control access to `RealAdminPanel`. This is useful in scenarios like permission validation or resource control. **Implementation pending.**

---

## Future Enhancements

* Implement full functionality of the admin control panel using the Proxy pattern.
* Add vehicle registration and parking logic.
* Extend GUI support using JavaFX or Swing.
* Improve exception handling and input validation.

---

## Author

* **Moustafa Mohamed**
[LinkedIn](https://www.linkedin.com/in/moustafamohamed01/) • [GitHub](https://github.com/MoustafaMohamed01) • [Kaggle](https://www.kaggle.com/moustafamohamed01)

* **Abdulkadir** [GitHub](https://github.com/AboudEy96/) • [Twitter](https://x.com/AboudEy96)
