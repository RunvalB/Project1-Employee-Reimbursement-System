package com.ers.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ers.dao.EmployeeDaoImpl;
import com.ers.dao.IEmployeeDao;
import com.ers.model.Employee;
import com.ers.model.Request;

public class EmployeeServiceImpl implements IEmployeeService {
	
	private static final Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class);
	IEmployeeDao employeeDao = new EmployeeDaoImpl();
	public List<Employee> getEmployeeUser(Employee emp) {
		try {
			LOGGER.info("inside method @getEmployeeUser service");
			return employeeDao.getEmployeeUser(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean submitRequest(Request emprequest) {
		try {
			LOGGER.info("inside method @submitRequest service");
			return employeeDao.employeeRequest(emprequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}	
}
