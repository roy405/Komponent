# Komponent
 Komponent is a vendor of computing hardware and accessories. The system developed is for komponent to extend their product line and services to their customer-base over the web. The developed system is a multi-layered application that is composed of the presentation layers which are the Web and Mobile UI, the business logic layer and the data layer where information is retrieved from and stored to. REST (Representational State Transfer) services are used in order to provide the backend to communicate with the front end. The system is equipped with proper authentication and authorization to allow a safe and secure experience for the users and the administrative officials alike.

# System Architecture
- 3-tier MVC architecture
- Front End Web Framework - ReactJS
- Front End Android Framework - Android Native (Java)
- Backend Framework - Spring Framework (Java), Hibernate, Lombok, RESTApi
- Database - MySQL RDBMS

# Functionalties
- Web-app pages:
 - Authentication- Users (both customers and admins) are required to login to the system using their credentials. Admin credentials are predefined whereas customers can create their own account from the registration page before logging in.
 - Customer:
  - Products List - Customers can view a list of all products that Komponent offers.
  - Product Details - Customers can interact with a specific product from the list of products to inspect the product details in a separate page.
  - Shopping Cart - Customers can add their desired products to the cart and then check the cart by pressing the card button. The cart consists of all selected products and the total price of the order.
  - Checkout - The checkout menu requires a customer to input their shipping and billing details along with the desired payment method, upon which it calculates the shipping amount and allows the customer to place an order.
  - User Account Management - Customers can view their information and edit them as necessary. 
  - Order History - Customers can see a list of all placed orders which consists of the order status.
 - Administrators:
  - Dashboard - Upon logging into the system, the administrators are presented with a dashboard that has information abou the most imminent items that require attention.
  - Product Management - Administrators can add, update or delete products from the system.
  - User List - Administrators can view a list of all users that are registered into the system.
- Mobile-app pages:
 - Login/Registration - Users can register through the registration page of the mobile application and upon a completed registration process can login to the system.
 - Home - The home page consists of a list of all products that Kompnent offers. 
 - Product Details - Customers can interact with a specific product from the list of products to inspect the product details in a separate page.
 - Shopping Cart - Customers can add their desired products to the cart and then check the cart by pressing the card button. The cart consists of all selected products and the total price of the order.
 - Checkout - The checkout menu requires a customer to input their shipping and billing details along with the desired payment method, upon which it calculates the shipping amount and allows the customer to place an order.
 - User Management - Customers can view their information and edit them as necessary.
 - Order List - Customers can see a list of all placed orders which consists of the order status from the menu bar.


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
