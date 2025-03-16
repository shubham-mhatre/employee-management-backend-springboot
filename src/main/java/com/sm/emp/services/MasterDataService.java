package com.sm.emp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sm.emp.dto.APIResponse;
import com.sm.emp.entity.ChildDepartment;
import com.sm.emp.entity.ParentDepartment;
import com.sm.emp.repositories.ChildDepartmentRepo;
import com.sm.emp.repositories.ParentDepartmentRepo;
import com.sm.emp.utility.Utility;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class MasterDataService {
	
	private final ParentDepartmentRepo parentDeptRepo;
	private final ChildDepartmentRepo childDepartmentRepo;
	private final Utility utility;
	
	public APIResponse getAllParentDepartment(){
		try {
			List<ParentDepartment> parentDeptData= parentDeptRepo.findAll();
			return utility.successResponse("List of Employee data found", parentDeptData);		
		}catch(Exception e) {
			return utility.errorResponse("Error occured while getting department list : Please contact support");
		}		
	} 
	
	
	public APIResponse getMappedChildDepartment(Integer parentDeptId) {
		try {
			List<ChildDepartment> childDepartment= childDepartmentRepo.findByParentDeptId(parentDeptId);
			return utility.successResponse("List of Employee data found",childDepartment);
		}catch(Exception e) {
			return utility.errorResponse("Error occured while getting child deparment list : Please contact support");
		}
	}
	
	

}
