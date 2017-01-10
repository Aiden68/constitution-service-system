package com.aiden.test.action;

import javax.annotation.Resource;

import com.aiden.test.service.TestService;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	
	@Resource
	TestService testService;
	
	
	public String execute(){
		return SUCCESS;
	}
}
