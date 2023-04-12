# Simple-Student-Management-System
This is a Student Management System designed to allow schools and universities to manage their students' data, including their personal information, academic records, and financial status. The system uses JDBC to connect to a MySQL database and perform CRUD (Create, Read, Update, Delete) operations on the student data.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [Credits](#credits)
- [License](#license)


## Installation
To use this system, you will need to have the following software installed:

- Java Development Kit (JDK) version 8 or higher
- MySQL Server
- MySQL Connector/J
To install the MySQL Connector/J driver, follow these steps:

Download the latest version of MySQL Connector/J from the official MySQL website.
Extract the downloaded archive to a folder of your choice.
Add the path to the mysql-connector-java-X.X.X.jar file to your Java classpath.
## Configuration
Before running the system, you will need to configure it to connect to your MySQL database. To do this, open the src/main/java/Database.java file and modify the following lines:

- private static final String URL = "jdbc:mysql://localhost:3306/Student";
- private static final String USERNAME = "root";
- private static final String PASSWORD = "password";

Replace localhost with the hostname or IP address of your MySQL server, Student with the name of your database, root with your MySQL username, and password with your MySQL password.

## Usage
To run the system, open a command prompt or terminal and navigate to the root directory of the project. Then, execute the following command:

- javac -d bin src/main/java/*.java
- java -classpath bin:lib/mysql-connector-java-X.X.X.jar Main

This will compile the Java source code and run the Main class. You should see a menu with the following options:

- Add student
- View student
- Update student
- Delete student
- Exit
Use the arrow keys to select an option and press Enter to confirm.

## Contributing
If you would like to contribute to this project, feel free to submit a pull request or open an issue on GitHub.

## Credits
This Text Editor was developed by Irfan Ansari as a programming exercise.

## License
This project is licensed under the MIT License. See the LICENSE file for more information.
