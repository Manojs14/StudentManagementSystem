# Student Management System

## Technologies Used
- **Java EE (Enterprise Edition)**
- **Servlets**
- **JSP Pages**
- **JDBC (Java Database Connectivity)**
- **MySQL** (as the database)
- **HTML/CSS/JavaScript** (for front-end interaction)

## Set Up the Database
1. **Create the Schema**: Create a MySQL database named `student_db`.
2. **Create the Table**: The `students` table should include the following columns:
   - `id`: Integer
   - `name`: Varchar
   - `email`: Varchar
   - `age`: Integer
3. **Import Data**: Import the `students.sql` file located in the `database` directory to set up the necessary table and sample data.

## Project Requirements
- **Dynamic Web Project**: Version 4.0
- **Server**: Apache Tomcat 9.0

## Configure Database Details
1. Navigate to the `dbdetails.properties` file located in `src/main/java/com/servlet/utilities/`.
2. Update the file with your MySQL database URL, username, and password.

## Run the Application
1. Deploy the application to a Java EE-compatible server (e.g., Apache Tomcat).
   - **Note**: The server used is Apache Tomcat 9. You may encounter errors during deployment, but they can be resolved using Tomcat version 9.
2. Access the application through a browser using the server's URL.

## Working
The Student Management System project allows users to input and store student details in a database. It supports CRUD operations (Create, Read, Update, Delete) on the stored data. 

- **Navigation Bar**: Provides easy access to different sections of the application.
- **View_Student**: Displays the stored data with options to edit or delete entries.
- **Add_Student**: Displays a form to add new student details, which will be stored in the database upon successful submission.

