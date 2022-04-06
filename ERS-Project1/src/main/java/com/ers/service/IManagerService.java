package com.ers.service;

import java.util.List;

import com.ers.exception.NoEmployeeResultFound;
import com.ers.model.Employee;
import com.ers.model.Request;

public interface IManagerService {

	public List<Employee> getManagerUser(Employee emp);
	public List<Employee> getAllEmployee(Employee employee);
	public List<Request> getAllRequest(Request requestObj);
	public boolean approvedRequest(Request req);
	public boolean resolvedRequest(Request req);
	public Employee getSpecificEmployeeDetail(Employee emp) throws NoEmployeeResultFound;

}
