package com.sm.emp.utility;

import org.springframework.stereotype.Component;

import com.sm.emp.dto.APIResponse;

@Component
public class Utility {
	
	public APIResponse errorResponse(String message) {
		APIResponse errorResponse=new APIResponse();
		errorResponse.setMessage(message);
		errorResponse.setResult(Boolean.FALSE);
		errorResponse.setData(null);
		
		return errorResponse;
	}
	
	public APIResponse successResponse(String message,Object response) {
		APIResponse errorResponse=new APIResponse();
		errorResponse.setMessage(message);
		errorResponse.setResult(Boolean.TRUE);
		errorResponse.setData(response);
		
		return errorResponse;
	}

}
