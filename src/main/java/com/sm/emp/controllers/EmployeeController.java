package com.sm.emp.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.emp.dto.APIResponse;
import com.sm.emp.dto.EmployeeDto;
import com.sm.emp.services.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping
	public APIResponse getAllEmployee() {
		return employeeService.getAllEmployeeData();
	}
	
	@PostMapping
	public APIResponse saveEmployee(@RequestBody EmployeeDto employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@DeleteMapping("/{id}")
	public APIResponse deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);			
	}
	
	@PutMapping
	public APIResponse updateEmployee(@RequestBody EmployeeDto employee) {
		return employeeService.updateEmployee(employee);
	}

}
