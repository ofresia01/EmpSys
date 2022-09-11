/*
    Interface class defining CRUD operations
 */
package com.ofresia01.emp_sys.service;

import com.ofresia01.emp_sys.data.models.Employee;
import com.ofresia01.emp_sys.data.payloads.request.EmpRequest;
import com.ofresia01.emp_sys.data.payloads.response.MsgResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component // Define class as bean at generic level for Spring
public interface EmpService {
    MsgResponse createEmployee(EmpRequest employeeRequest);
    Optional<Employee> updateEmployee(Integer employeeId, EmpRequest employeeRequest);
    void deleteEmployee(Integer employeeId);
    Employee getSingleEmployee(Integer employeeId);
    List<Employee> getAllEmployee();
}