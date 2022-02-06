package com.codedailly.contoller;

import com.codedailly.entity.Employee;
import com.codedailly.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired(required=true)
    private EmployeeService employeeService;


    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId){
        return employeeService.getEmployeee(employeeId);
    }

    @GetMapping("/list")
    public List<Employee> getEmployeeList(){
        return employeeService.getEmployeeList();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee){
        return employeeService.updateEmployee(employeeId, employee);

    }

    @DeleteMapping("/delete/{employeeId}")
    public void delete(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }

}
