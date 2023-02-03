## Choose one of these two assignments

1. Library management system:
   Turn the fundamentals assignment into a backend server with a persistent database
2. E-commerce, Turn the fundamentals assignment into a backend server with a persistent database

`All entities you created would be a Database Entity (Table)`



*Follow this approach from basic to advanced. where the basic is required and the rest is optional.*

PS. if your goal is advanced and you haven't built a Spring Boot application before then I recommend you to start from Basic and gradually refactor your code to be advanced.

**Basic approach *(Required)* **

* Basic routes, ie CRUD operations for entities
* There's no need to build any relation between tables
* There's no need to handle validation errors/ or internal exceptions (the part we skipped)
* In-memory database or persistent database, (PostgreSQL or MySQL)
* No Role is required, everyone and anyone can do CRUD

**Intermediate (Optional)**

* Add relations between tables
* Learn the [DTO pattern](https://www.baeldung.com/java-dto-pattern)
* Handle validation and exception errors
* Persistent database, (PostgreSQL or MySQL)

**Advanced (Optional)**

* Handle authentication via Spring Security, ie create a signing/signup routes where you send back token depending on the user if it's normie or admin user.
* Build authorization a role-based-system with Admin and User or more privileges
* Run your application and DataBase from Docker
