package com.sm.emp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.emp.entity.ParentDepartment;

@Repository
public interface ParentDepartmentRepo extends JpaRepository<ParentDepartment, Integer> {

}
