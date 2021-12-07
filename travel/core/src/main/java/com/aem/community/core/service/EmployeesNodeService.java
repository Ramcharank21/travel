package com.aem.community.core.service;

public interface EmployeesNodeService {
	
	public boolean registerEmployDetails(String firstName,String lastName,String userName,String password);
	public boolean loginEmployee(String user,String pass);	
	
}
