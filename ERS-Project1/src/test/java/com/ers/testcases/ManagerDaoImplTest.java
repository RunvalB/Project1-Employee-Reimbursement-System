package com.ers.testcases;

import java.util.List;

import com.ers.dao.IManagerDao;
import com.ers.dao.ManagerDaoImpl;
import com.ers.exception.NoEmployeeResultFound;
import com.ers.model.Employee;
import com.ers.model.Request;

import junit.framework.TestCase;

public class ManagerDaoImplTest extends TestCase {

	IManagerDao empdao = new ManagerDaoImpl();
	public void testGetManagerUser() {
		Employee empobj = new Employee();
		empobj.setEmail("manager@emp");
		empobj.setPassword("iammanager");
		empobj.setManager(true);
		empobj.setWorking(true);
		List<Employee> count=empdao.getManagerUser(empobj);
		assertEquals(1, count.size());
	}

	public void testGetAllEmployee() {
		Employee emp= new Employee();
		List<Employee> count = empdao.getAllEmployee(emp);
		assertEquals(count.size(), count.size());
	}

	public void testGetAllRequest() {
		Request req = new Request();
		List<Request> count = empdao.getAllRequest(req);
		assertEquals(count.size(), count.size());
	}

	public void testApprovedRequest() {
		Request req = new Request();
		req.setApproved(true);
		req.setReqid(1);
		assertEquals(1,empdao.approvedRequest(req));
	}

	public void testResolvedRequest() {
		Request req = new Request();
		req.setReqStatus(true);
		req.setReqid(1);
		assertEquals(1,empdao.resolvedRequest(req));
		
	}

	public void testGetSpecificEmployeeDetail() throws NoEmployeeResultFound {
		Employee emp = new Employee();
		emp.setEmail("unknown@gmail.com");
		Employee emp1 = empdao.getSpecificEmployeeDetail(emp);
		assertNotNull(emp1);
	}

}
