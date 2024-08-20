
Technologies Used
Java EE (Enterprise Edition)
Servlets
JSP pages
JDBC (Java Database Connectivity)
MySQL (as the database)
HTML/CSS/JavaScript (for front-end interaction)


=======
# StudentManagementSystem
>>>>>>> origin/main



Set up the database:
schema named student_db.
Create a MySQL database named students.
students contains colm id, name, email, age.
Import the students.sql file located in the database directory to set up the necessary table and sample data.

use dynamic web project 4.0
use the tomcat server 9.0


Configure database details:
Update dbdetails.properties file located in src/main/java/com/servlet/utilities/ with your MySQL database URL, username, and password.


Run the application:
Deploy the application to a Java EE compatible server (e.g., Apache Tomcat).
the server used is  apache tomcat 9;
it will show the error but can be compiled using tomcat 9 version.
Access the application through the browser using the server's URL.

Working:
This Student Management System project allows users to input and store student details in a database.
It supports CRUD operations (Create, Read, Update, Delete) on the stored data. 
The project features a navigation bar for easy access to different pages. 
The "View_Student" section displays the stored data, along with options to edit or delete entries.
The "Add_Student" section displays the form upon successfull submission the data will get stored in db.


