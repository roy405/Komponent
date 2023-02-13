# Komponent
 An ecommerce website for computing hardware and accessories.

# System Architecture
- 3-tier MVC architecture
- Front End Web Framework - ReactJS
- Front End Android Framework - Android Native (Java)
- Backend Framework - Spring Framework (Java), Hibernate, Lombok, RESTApi
- Database - MySQL RDBMS

# Functionalties
- Web-app pages:
 - Authentication
 - Customer
  - Product Details
  - Shopping Cart
  - Checkout
  - User Account Management
  - Order History
 - Admin
  - Dashboard
  - Adding Products
  - User List
- Mobile-app pages:
 - Login/Registration
 - Home
 - Product Details
 - Shopping Cart
 - Checkout
 - User Management
 - Order List


# How to run
- Frontend Web-Server:
 - Install Nodejs
 - Go to the salesreact folder and open termianl
 - run following commands
  ```
  npm start
  ```
- Frontend Mobile applcation:
 - The applcation can be directly installed on a device using the apk.
 - To use on an emulator, download Android Studio and run the application

- Backend Server:
 - Install Eclipse IDE (Spring source toolsuite) or Jetbrains IntelliJ IDE. Both of these have a built in Apache Tomcat server to run spring applications locally.
 - Run the backend server through the IDE
 - Use the provided .sql file to load the database schema for dummy data (consists of user, products, customer data).
