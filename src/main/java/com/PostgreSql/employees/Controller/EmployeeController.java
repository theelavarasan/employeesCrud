package com.PostgreSql.employees.Controller;

import com.PostgreSql.employees.Entity.Employee;
import com.PostgreSql.employees.Service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

//    private Logger log = LoggerFactory.getLogger(EmployeeController.class);
    Logger logger =LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> findAllEmployee(){
        logger.trace("TRACE ERROR");
        return service.findAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/create")
    public Employee saveEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteEmployee(@PathVariable Long id){
        return service.deleteEmployee(id);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll(){
        return service.deleteAll();
    }
}
