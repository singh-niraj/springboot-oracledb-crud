package com.oracle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.entity.Employee;
import com.oracle.exceptions.ResourceNotFoundException;
import com.oracle.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	//save employee
	@PostMapping("/saveemp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	//get employee
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") int employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeService.getEmpById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with id : " + employeeId));

		return ResponseEntity.ok().body(employee);
	}

	//get employees
	@GetMapping("/allemployees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	

	//delete employee
	@DeleteMapping("/employee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeService.getEmpById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with id : " + employeeId));

		this.employeeService.deleteEmployeeById(employee.getId());

		Map<String, Boolean> response = new HashMap<>();
		response.put("Successfully deleted", Boolean.TRUE);
		return response;

	}
}
