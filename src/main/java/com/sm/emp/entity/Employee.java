package com.sm.emp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Integer employeeId;

	@Column(name="employee_name")
	private String employeeName;

	@Column(name="contact_number")
	private String contactNumber;

	@Column(name="employee_email_id")
	private String employeeEmailId;

	@Column(name="gender")
	private String gender;

	@Column(name="child_dept_id")
	private Integer childDeptId;
	
	private String password;
	
	@ManyToOne
    @JoinColumn(name = "child_dept_id", referencedColumnName = "id", insertable = false, updatable = false)
	@JsonBackReference
    private ChildDepartment childDepartment;
}
