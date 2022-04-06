package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import com.ers.model.Employee;
import com.ers.service.IManagerService;
import com.ers.service.ManagerServiceImpl;

@SuppressWarnings("serial")
public class ViewAllEmployee extends HttpServlet implements Serializable{
	private static final Logger LOGGER = Logger.getLogger(ViewAllEmployee.class);
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("class @ViewAllEmployee inside @Service method");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link href='main.css' rel='stylesheet'>");
		Employee employee = new Employee();
		employee.setManager(false);
		IManagerService managerObj = new ManagerServiceImpl();
		LOGGER.info("class @ViewAllEmployee GetAllEmployee call...");
		List<Employee> allemployee = managerObj.getAllEmployee(employee);
		out.println("<h3>Total Employee are : "+allemployee.size()+"</h3>");
		if(!allemployee.isEmpty()) {
			out.println("<table><tr><th>Name</th> <th>Email</th> <th>Department</th> <th>Salary</th> <th>MobileNo</th> <th>Gender</th> </tr>");
			for (Employee employee2 : allemployee) {
				out.println("<tr> <td>"+employee2.getName() +"</td>");
				out.println("<td>"+employee2.getEmail()+"</td>");
				out.println("<td>"+employee2.getDepartment()+"</td>");
				out.println("<td>"+employee2.getSalary()+"</td>");
				out.println("<td>"+employee2.getMobileNumber()+"</td>");
				out.println("<td>"+employee2.getGender()+"</td></tr>");
			}
			out.println("</table>");
		}
	}
}
