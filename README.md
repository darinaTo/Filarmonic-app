# Filarmonic app
 The goal of this project do some basic functions and standard roles. The user can register or log in, buy tickets get all concerts. 
 The project was built according to 3-tier architecture.

## Technologies
- Spring Web/Security/Mvc
- Hibernate
- SQL
- Maven
- Tomcat

## Setup
1. Open the project in an IDE.
2. Install MySql Workbench and in the resources/db.properties change the _url_, _driver_, _user_ and _password_.
3. Configure Tomcat(Local).
4. Run project.
5. Create and add information about User (password and email).

## User actions depending on the role
### User can:
- process the order
- view a history of all the orders
- view all the tickets in the shopping cart
- add the ticket for concert to the shopping cart

### Admin can:
- find user by email
- add new concert
- add new stage
- add new concert session, delete or update
