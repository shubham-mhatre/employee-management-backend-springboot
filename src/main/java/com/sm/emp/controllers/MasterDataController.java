package com.sm.emp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sm.emp.dto.APIResponse;
import com.sm.emp.services.MasterDataService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MasterDataController {
	
	private final MasterDataService masterDataService;
	
	@GetMapping("/getallparentdepartment")
	public APIResponse getAllParentDepartment() {
		return masterDataService.getAllParentDepartment();
	}
	
	 @GetMapping("/child-department/{id}")
	 public APIResponse getChildDepartmentsByParentId(@PathVariable int id) {
		 return masterDataService.getMappedChildDepartment(id);
	 }
	

}
