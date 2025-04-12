package com.sm.emp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="child_department")
public class ChildDepartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer childDeptId;
	
	@Column(name="p_dept_id")
	private Integer parentDeptId;
	
	private String role;
	
	@ManyToOne
    @JoinColumn(name = "p_dept_id", referencedColumnName = "dept_id", insertable = false, updatable = false)
	@JsonBackReference
    private ParentDepartment parentDepartment;

    @OneToMany(mappedBy = "childDepartment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Employee> employees;
}
