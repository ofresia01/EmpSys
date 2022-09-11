/*
    Java class implementing CRUD operations defined in EmpService
 */
package com.ofresia01.emp_sys.service;

import com.ofresia01.emp_sys.data.models.Employee;
import com.ofresia01.emp_sys.data.payloads.request.EmpRequest;
import com.ofresia01.emp_sys.data.payloads.response.MsgResponse;
import com.ofresia01.emp_sys.data.repository.EmpRepository;
import com.ofresia01.emp_sys.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Define class as bean in Service level for Spring
public class EmpServiceImp implements EmpService{
    @Autowired // Dependency injection for EmpService interface class
    EmpRepository employeeRepository;

    // Implementation of EmpService interface methods

    @Override
    public MsgResponse createEmployee(EmpRequest employeeRequest) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employeeRequest.getFirstName());
        newEmployee.setLastName(employeeRequest.getLastName());
        newEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
        newEmployee.setEmail(employeeRequest.getEmail());
        newEmployee.setSalary(employeeRequest.getSalary());
        newEmployee.setDepartment(employeeRequest.getDepartment());
        employeeRepository.save(newEmployee);
        return new MsgResponse("New Employee created");
    }

    @Override
    public Optional<Employee> updateEmployee(Integer employeeId, EmpRequest employeeRequest) throws ResourceNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new ResourceNotFoundException("Employee", "ID", employeeId); // Throws exception if employee ID isn't found
        }
        else {
            employee.get().setFirstName(employeeRequest.getFirstName());
            employee.get().setLastName(employeeRequest.getLastName());
            employee.get().setPhoneNumber(employeeRequest.getPhoneNumber());
            employee.get().setEmail(employeeRequest.getEmail());
            employee.get().setSalary(employeeRequest.getSalary());
            employee.get().setDepartment(employeeRequest.getDepartment());
            employeeRepository.save(employee.get());
            return employee;
        }
    }

    @Override
    public void deleteEmployee(Integer employeeId) throws ResourceNotFoundException {
        if (employeeRepository.getReferenceById(employeeId).getId().equals(employeeId)) {
            employeeRepository.deleteById(employeeId);
        }
        else throw new ResourceNotFoundException("Employee", "ID", employeeId); // Throws exception if employee ID isn't found
    }

    @Override
    public Employee getSingleEmployee(Integer employeeId) throws ResourceNotFoundException {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", employeeId)); // Throws exception if employee ID isn't found
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}