package com.codedailly.service;

import com.codedailly.entity.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();


    @PostConstruct
    public void loadEmployeeDetails(){
        Employee employee1 = new Employee(101L, "RK", 100000D, 2L);
        Employee employee2 = new Employee(102L, "YK", 13000D, 3L);
        Employee employee3 = new Employee(103L, "Srinivas", 140000D, 2L);
        Employee employee4 = new Employee(104L, "Dariya", 1000D, 4L);
        Employee employee5 = new Employee(105L, "Vamsi", 17000D, 2L);
        Employee employee6 = new Employee(106L, "Hari", 36000D, 5L);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);
    }

    public Employee getEmployeee(Long employeeId){
          Employee employee = new Employee();
        if(employeeId == 100) {
            employee.setEmployeeId(100L);
            employee.setEmployeeName("yak");
            employee.setSalary(120000D);
            employee.setDepartmentId(1L);
        }else{
            employee = null;
        }
        return employee;
    }

    public List<Employee> getEmployeeList(){
        return this.employeeList;
    }

    public Employee addEmployee(Employee employee) {
        this.employeeList.add(employee);
        return  employee;
    }

    public Employee updateEmployee(Long employeeId, Employee requestBody) {
        Employee updatedEmployee = null;
        for(Employee employee:employeeList){
            if(employee.getEmployeeId() == employeeId){
                updatedEmployee = employee;
                updatedEmployee.setEmployeeName(requestBody.getEmployeeName());
                updatedEmployee.setDepartmentId(requestBody.getDepartmentId());
                updatedEmployee.setSalary(requestBody.getSalary());
            }
        }
     return updatedEmployee;
    }

    public void deleteEmployee(Long employeeId) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = this.employeeList.get(i);
            if(employee.getEmployeeId() == employeeId){
                this.employeeList.remove(i);
            }

        }

    }
}
