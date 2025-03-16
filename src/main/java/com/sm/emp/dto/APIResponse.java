package com.sm.emp.dto;

import lombok.Data;

@Data
public class APIResponse {

	private String message;
	private boolean result;
	private Object data;
}
