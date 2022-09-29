package com.PostgreSql.employees.Service;

import com.PostgreSql.employees.Entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployee();
    Employee findById(Long id);
    Employee saveEmployee(Employee employee);
    ResponseEntity<String> updateEmployee(Employee employee);
    ResponseEntity<String> deleteEmployee(Long id);
    ResponseEntity<String> deleteAll();
}
