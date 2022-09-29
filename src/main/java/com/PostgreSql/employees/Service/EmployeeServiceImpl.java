package com.PostgreSql.employees.Service;
import com.PostgreSql.employees.Entity.Employee;
import com.PostgreSql.employees.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAllEmployee() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("Employee found for the id "+ id));
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public ResponseEntity<String> updateEmployee(Employee employee) {
         repository.save(employee);
         return new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteEmployee(Long id) {
         repository.deleteById(id);
         return new ResponseEntity<String>("The " + id + "Id has deleted Successfully",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAll() {
        repository.deleteAll();
        return new ResponseEntity<String>("All Employees Deleted Successfully", HttpStatus.OK);
    }
}
