package com.sm.emp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.emp.entity.ChildDepartment;
import java.util.List;


@Repository
public interface ChildDepartmentRepo extends JpaRepository<ChildDepartment, Integer> {

	List<ChildDepartment> findByParentDeptId(Integer parentDeptId);
}
