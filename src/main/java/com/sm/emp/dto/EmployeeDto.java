package com.sm.emp.dto;

import lombok.Data;

@Data
public class EmployeeDto {

	private Integer employeeId;

	private String employeeName;

	private String contactNumber;

	private String employeeEmailId;

	private String gender;
	
	private Integer deptId;
	private String departmentName;
	
	private String role;
	
	private Integer childDeptId;
	
	private String password;
}
