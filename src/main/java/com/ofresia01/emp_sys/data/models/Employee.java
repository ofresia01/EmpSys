/*
    Domain class generating ID, defining attributes with accessors/mutators
 */
package com.ofresia01.emp_sys.data.models;

import javax.persistence.*;
import java.util.Objects;

@Entity // Defines class to be mapped to database table
public class Employee {
    @Id // Defines ID as primary key of employee table in database
    @GeneratedValue(strategy = GenerationType.AUTO) // Automatically generate ID

    // Define variables for employee
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private double salary;
    @Enumerated(EnumType.STRING)
    private Department department;

    // Constructor
    public Employee() {};

    // Accessors and mutators
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    // Override toString
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName = " + firstName + '\'' +
                ", lastName = " + lastName + '\'' +
                ", phoneNumber = " + phoneNumber + '\'' +
                ", email = " + email + '\'' +
                ", salary = " + salary + '\'' +
                ", department = " + department +
                '}';
    }

    // Override equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // If o is same object, return true
        if (o == null || getClass() != o.getClass()) return false; // If o is empty or getClass not equal, return false
        Employee employee = (Employee) o;
        // Compare all attributes
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(phoneNumber, employee.phoneNumber) &&
                Objects.equals(email, employee.email) &&
                department == employee.department;
    }

    //Override hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, email, salary, department);
    }
}