package com.ers.dao;

import java.util.List;

import com.ers.model.Employee;
import com.ers.model.Request;

public interface IEmployeeDao {

	public List<Employee> getEmployeeUser(Employee emp);
	public boolean employeeRequest(Request emprequest);
	

}
