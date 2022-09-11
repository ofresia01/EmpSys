/*
    Controller class for HTTP request handling
 */
package com.ofresia01.emp_sys.web;

import com.ofresia01.emp_sys.data.models.Employee;
import com.ofresia01.emp_sys.data.payloads.request.EmpRequest;
import com.ofresia01.emp_sys.data.payloads.response.MsgResponse;
import com.ofresia01.emp_sys.service.EmpService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Spring annotation defining class as HTTP request handler
@RequestMapping("/employee") // Sets path of resource endpoints in controller
// API Responses with Swagger
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 401, message = "Authorization fail"),
        @ApiResponse(code = 500, message = "Server not responding")
})
public class EmpController {
    @Qualifier("empServiceImp")
    @Autowired // Dependency injection for EmpService interface class
    EmpService employeeService;

    @GetMapping("/all") // Map HTTP GET request for all employees
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}") // Map HTTP GET request for single employee
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) { // @PathVariable bounds id to URI
        Employee employee = employeeService.getSingleEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add") // Map HTTP POST request for adding employee
    public ResponseEntity<MsgResponse> addEmployee(@RequestBody EmpRequest employee) { // @RequestBody binds web request body to employee object
        MsgResponse newEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}") // Map HTTP PUT request for updating employee
    public Optional<Employee> updateEmployee(@PathVariable Integer id, @RequestBody EmpRequest employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping // Map HTTP DELETE request for deleting employee
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}