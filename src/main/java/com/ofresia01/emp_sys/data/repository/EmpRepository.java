/*
    Interface class extending JpaRepository to inherit save, findAll, and findById methods
 */
package com.ofresia01.emp_sys.data.repository;

import com.ofresia01.emp_sys.data.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Define class as bean at persistence layer for Spring
public interface EmpRepository extends JpaRepository<Employee, Integer> {

}