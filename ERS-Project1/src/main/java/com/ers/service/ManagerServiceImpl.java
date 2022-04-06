package com.ers.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.ers.dao.IManagerDao;
import com.ers.dao.ManagerDaoImpl;
import com.ers.exception.NoEmployeeResultFound;
import com.ers.model.Employee;
import com.ers.model.Request;

public class ManagerServiceImpl implements IManagerService {
	private static final Logger LOGGER = Logger.getLogger(ManagerServiceImpl.class);
	IManagerDao managerDao = new ManagerDaoImpl();
	public List<Employee> getManagerUser(Employee emp) {
			try {
				LOGGER.info("Inside @getManagerUser service");
				return managerDao.getManagerUser(emp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	public List<Employee> getAllEmployee(Employee employee) {
		try {
			LOGGER.info("Inside @getAllEmployee service");
			return managerDao.getAllEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public List<Request> getAllRequest(Request requestObj) {
		try {
			LOGGER.info("Inside @getAllRequest service");
			return managerDao.getAllRequest(requestObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public boolean approvedRequest(Request req) {
		try {
			LOGGER.info("Inside @approvedRequest service");
			if(managerDao.approvedRequest(req) > 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean resolvedRequest(Request req) {
		try {
			LOGGER.info("Inside @resolvedRequest service");
			if(managerDao.resolvedRequest(req) > 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public Employee getSpecificEmployeeDetail(Employee emp) throws NoEmployeeResultFound{
		try {
			LOGGER.info("Inside @getSpecificEmployeeDetail service");
			return managerDao.getSpecificEmployeeDetail(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
