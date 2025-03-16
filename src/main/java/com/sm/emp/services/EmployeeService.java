package com.sm.emp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sm.emp.dto.APIResponse;
import com.sm.emp.dto.EmployeeDto;
import com.sm.emp.entity.Employee;
import com.sm.emp.repositories.EmployeeRepo;
import com.sm.emp.utility.Utility;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeeService {

	private final EmployeeRepo employeeRepo;
	private final Utility utility;

	public APIResponse getAllEmployeeData() {
		try {
			List<Employee> employeeList =employeeRepo.findAll();

			List<EmployeeDto> employeeDtoList = employeeList.stream()
					.map(employee -> {
						EmployeeDto dto = new EmployeeDto();
						dto.setEmployeeId(employee.getEmployeeId());
						dto.setContactNumber(employee.getContactNumber());
						dto.setEmployeeEmailId(employee.getEmployeeEmailId());
						dto.setEmployeeName(employee.getEmployeeName());
						dto.setGender(employee.getGender());
						dto.setDepartmentName(employee.getChildDepartment().getParentDepartment().getDepartmentName());
						dto.setRole(employee.getChildDepartment().getRole());
						return dto;
					}).toList();



			return utility.successResponse("employee data fetched ", employeeDtoList);
		}catch(Exception e) {
			return utility.errorResponse("something went wrong while fetching employee data. Please contact support");
		}
	}

}
