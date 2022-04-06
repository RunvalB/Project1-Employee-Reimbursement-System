package com.ers.testcases;

import java.util.Date;
import java.util.List;

import com.ers.dao.EmployeeDaoImpl;
import com.ers.dao.IEmployeeDao;
import com.ers.model.Employee;
import com.ers.model.Request;

import junit.framework.TestCase;

public class EmployeeDaoImplTest extends TestCase {

	IEmployeeDao empdao = new EmployeeDaoImpl();
	public void testGetEmployeeUser() {
//		fail("Not yet implemented");
		Employee empobj = new Employee();
		empobj.setEmail("runval@gmail.com");
		empobj.setPassword("runvalEmp");
		empobj.setManager(false);
		empobj.setWorking(true);
		List<Employee> count=empdao.getEmployeeUser(empobj);
		assertEquals(1,count.size());
	}

	public void testEmployeeRequest() {
//		Request req = new Request();
//		req.setAmount(10000);
//		req.setApproved(false);
//		req.setSubmitdate(new Date());
//		req.setReqStatus(false);
//		req.setType("Claim Reimbursement");
//		Employee empobj = new Employee();
//		empobj.setEmpid(1);
//		req.setEmployee(empobj);
//		assertEquals(true,empdao.employeeRequest(req));	
	}
}
