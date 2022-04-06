package com.ers.dao;

import java.util.List;

import com.ers.exception.NoEmployeeResultFound;
import com.ers.model.Employee;
import com.ers.model.Request;

public interface IManagerDao {

	public List<Employee> getManagerUser(Employee emp);
	public List<Employee> getAllEmployee(Employee employee);
	public List<Request> getAllRequest(Request requestObj);
	public int approvedRequest(Request req);
	public int resolvedRequest(Request req);
	public Employee getSpecificEmployeeDetail(Employee emp) throws NoEmployeeResultFound;
	
}
