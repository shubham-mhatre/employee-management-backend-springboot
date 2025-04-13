package com.sm.emp.services;

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

	public APIResponse saveEmployee(EmployeeDto employee) {
		try {
			Employee employeeEntity=new Employee();
			employeeEntity.setEmployeeEmailId(employee.getEmployeeEmailId());
			employeeEntity.setContactNumber(employee.getContactNumber());
			employeeEntity.setEmployeeName(employee.getEmployeeName());
			employeeEntity.setGender(employee.getGender());
			employeeEntity.setChildDeptId(employee.getChildDeptId());
			employeeEntity.setPassword(employee.getPassword());
			employeeRepo.save(employeeEntity);
			return utility.successResponse("employee saved successfully ", employeeEntity);
		}catch (Exception e) {
			return utility.errorResponse("something went wrong while saving employee data. Please contact support");
		}
	}

	public APIResponse deleteEmployee(int id) {
		try {
			Employee employeeEntity = employeeRepo.findById(id).orElse(null);
			if(employeeEntity!=null) {
				employeeRepo.delete(employeeEntity);
				return utility.successResponse("employee deleted successfully ", employeeEntity);
			}else {
				throw new Exception("employee with id : "+id+" not found");
			}
		}catch(Exception e) {
			return utility.errorResponse("something went wrong while deleting employee data. Please contact support");
		}

	}

}
