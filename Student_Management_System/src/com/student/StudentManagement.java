package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentManagement {
	

	private static final String DB_URL = "jdbc:mysql://localhost:3306/Student";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    
	public static void main(String[] args) throws ClassNotFoundException {
//		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // Connect to the database
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create a statement object
            stmt = conn.createStatement();
            System.out.println("Creating the table");
            // Create a table for student data if it doesn't exist already
            String createTable = "CREATE TABLE IF NOT EXISTS students ("
                    + "id INT(11) NOT NULL AUTO_INCREMENT,"
                    + "name VARCHAR(50) NOT NULL,"
                    + "address VARCHAR(100) NOT NULL,"
                    + "phone VARCHAR(20) NOT NULL,"
                    + "email VARCHAR(50) NOT NULL,"
                    + "dob DATE NOT NULL,"
                    + "enrollment_date DATE NOT NULL,"
                    + "department VARCHAR(50) NOT NULL,"
                    + "PRIMARY KEY (id)"
                    + ")";
            stmt.executeUpdate(createTable);

            Scanner sc = new Scanner(System.in);
            int choice;
            
            do {
                // Display the menu
                System.out.println("Student Management System");
                System.out.println("1. Add student");
                System.out.println("2. View student details");
                System.out.println("3. Update student details");
                System.out.println("4. Delete student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        // Add a new student
                        System.out.print("Enter student name: ");
                        String name = sc.next();
                        System.out.print("Enter student address: ");
                        String address = sc.next();
                        System.out.print("Enter student phone number: ");
                        String phone = sc.next();
                        System.out.print("Enter student email: ");
                        String email = sc.next();
                        System.out.print("Enter student date of birth (YYYY-MM-DD): ");
                        String dob = sc.next();
                        System.out.print("Enter student enrollment date (YYYY-MM-DD): ");
                        String enrollmentDate = sc.next();
                        System.out.print("Enter student department: ");
                        String department = sc.next();

                        // Insert the student data into the database
                        String insertStudent = "INSERT INTO students "
                                + "(name, address, phone, email, dob, enrollment_date, department) "
                                + "VALUES ('" + name + "', '" + address + "', '" + phone + "', '" + email + "', '"
                                + dob + "', '" + enrollmentDate + "', '" + department + "')";
                        stmt.executeUpdate(insertStudent);
                        System.out.println("\nStudent added successfully");
                        break;
                    case 2:
                        // View student details
                        System.out.print("Enter student ID: ");
                        int id = sc.nextInt();

                        // Retrieve the student data from the database
                        String selectStudent = "SELECT * FROM students WHERE id = " + id;
                        rs = stmt.executeQuery(selectStudent);
                        if (rs.next()) {
                            System.out.println("Name: " + rs.getString("name"));
                            System.out.println("Address: " + rs.getString("address"));
                            System.out.println("Phone: " + rs.getString("phone"));
                            System.out.println("Email: " + rs.getString("email"));
                            System.out.println("Date of Birth: " + rs.getString("dob"));
                            System.out.println("Department: " + rs.getString("department"));
                            System.out.println("Enrollment Date: " + rs.getString("enrollment_date"));
                        } else {
                        System.out.println("No student found with ID " + id);
                        }
                        break;
                        case 3:
                        // Update student details
                        System.out.print("Enter student ID: ");
                        int updateId = sc.nextInt();
                        System.out.print("Enter student name: ");
                        String updateName = sc.next();
                        System.out.print("Enter student address: ");
                        String updateAddress = sc.next();
                        System.out.print("Enter student phone number: ");
                        String updatePhone = sc.next();
                        System.out.print("Enter student email: ");
                        String updateEmail = sc.next();
                        System.out.print("Enter student date of birth (YYYY-MM-DD): ");
                        String updateDob = sc.next();
                        System.out.print("Enter student enrollment date (YYYY-MM-DD): ");
                        String updateEnrollmentDate = sc.next();
                        System.out.print("Enter student department: ");
                        String updateDepartment = sc.next();
                        
                        // Update the student data in the database
                        String updateStudent = "UPDATE students SET "
                                + "name = '" + updateName + "', "
                                + "address = '" + updateAddress + "', "
                                + "phone = '" + updatePhone + "', "
                                + "email = '" + updateEmail + "', "
                                + "dob = '" + updateDob + "', "
                                + "enrollment_date = '" + updateEnrollmentDate + "', "
                                + "department = '" + updateDepartment + "' "
                                + "WHERE id = " + updateId;
                        int rowsAffected = stmt.executeUpdate(updateStudent);
                        if (rowsAffected > 0) {
                            System.out.println("Student details updated successfully");
                        } else {
                            System.out.println("No student found with ID " + updateId);
                        }
                        break;
                    case 4:
                        // Delete a student
                        System.out.print("Enter student ID: ");
                        int deleteId = sc.nextInt();

                        // Delete the student data from the database
                        String deleteStudent = "DELETE FROM students WHERE id = " + deleteId;
                        rowsAffected = stmt.executeUpdate(deleteStudent);
                        if (rowsAffected > 0) {
                            System.out.println("Student deleted successfully");
                        } else {
                            System.out.println("No student found with ID " + deleteId);
                        }
                        break;
                    case 5:
                        // Exit the program
                        System.out.println("Exiting Student Management System...");
                        break;
                    default:
                        System.out.println("Invalid choice, please enter a valid choice");
                }
            } while (choice != 5);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
	}
}
       
	


