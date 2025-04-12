package com.sm.emp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sm.emp.dto.APIResponse;
import com.sm.emp.dto.ChildDepartmentDto;
import com.sm.emp.dto.ParentDepartmentDto;
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
			List<ParentDepartmentDto> dtoList= parentDeptData.stream().map(data->{
				ParentDepartmentDto dto=new ParentDepartmentDto();
				dto.setDepartmentName(data.getDepartmentName());
				dto.setDeptId(data.getDeptId());
				return dto;
			}).toList();
			return utility.successResponse("List of Employee data found", dtoList);		
		}catch(Exception e) {
			return utility.errorResponse("Error occured while getting department list : Please contact support");
		}		
	} 
	
	
	public APIResponse getMappedChildDepartment(Integer parentDeptId) {
		try {
			List<ChildDepartment> childDepartment= childDepartmentRepo.findByParentDeptId(parentDeptId);
			List<ChildDepartmentDto>dtoList= childDepartment.stream().map(data->{
				ChildDepartmentDto dto=new ChildDepartmentDto();
				dto.setChildDeptId(data.getChildDeptId());
				dto.setParentDeptId(data.getParentDeptId());
				dto.setRole(data.getRole());
				return dto;
			}).toList();
			return utility.successResponse("List of Employee data found",dtoList);
		}catch(Exception e) {
			return utility.errorResponse("Error occured while getting child deparment list : Please contact support");
		}
	}
	
	

}
