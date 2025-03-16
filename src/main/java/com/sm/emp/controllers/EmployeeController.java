package com.sm.emp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.emp.dto.APIResponse;
import com.sm.emp.services.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping("/getallemployees")
	public APIResponse getAllEmployee() {

		return employeeService.getAllEmployeeData();
	}

}
