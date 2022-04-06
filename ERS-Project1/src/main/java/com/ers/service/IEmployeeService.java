package com.ers.service;

import java.util.List;


import com.ers.model.Employee;
import com.ers.model.Request;

public interface IEmployeeService {

	public List<Employee> getEmployeeUser(Employee emp);
	public boolean submitRequest(Request emprequest);

}
