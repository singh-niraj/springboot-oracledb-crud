package com.oracle.service;

import com.oracle.entity.Employee;
import com.oracle.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmpById(int id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

}
