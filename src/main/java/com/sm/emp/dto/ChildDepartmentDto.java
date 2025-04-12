package com.sm.emp.dto;

import lombok.Data;

@Data
public class ChildDepartmentDto {
	 private Integer childDeptId;
	 private Integer parentDeptId;
	 private String role;
}
