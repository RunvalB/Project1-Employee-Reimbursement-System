package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ers.model.Employee;
import com.ers.service.EmployeeServiceImpl;
import com.ers.service.IEmployeeService;
import com.ers.service.IManagerService;
import com.ers.service.ManagerServiceImpl;

@SuppressWarnings("serial")
public class Login extends HttpServlet implements Serializable{
	
	private static final Logger LOGGER = Logger.getLogger(Login.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Application Started");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link href='main.css' rel='stylesheet'>");
		
		LOGGER.info("Login Request Comes from user");
		String role = request.getParameter("user-role");
		String email = request.getParameter("user-email");
		String password = request.getParameter("user-password");
		
		//create session using getsession(true)
		HttpSession s = request.getSession(true);
		
		// make session interval time 0 for never timeout
		s.setMaxInactiveInterval(0);
		Employee emp = new Employee();
		try {
			if(role.equalsIgnoreCase("employee")) {
				LOGGER.info("Inside Employee Block");
				//setters manager and working 
				boolean isManager= false;
				boolean isWorking = true;
				emp.setEmail(email);
				emp.setPassword(password);
				emp.setManager(isManager);
				emp.setWorking(isWorking);
				
				IEmployeeService employeeObj = new EmployeeServiceImpl();
				LOGGER.info("controller call getEmployeeUser");
				List<Employee> resultEmployee = employeeObj.getEmployeeUser(emp);
				if(resultEmployee.size()==1) {
					LOGGER.info("Employee User Login Operation Successful...");
					for (Employee employee : resultEmployee) {
						//set Employee Attributes  
						s.setAttribute("id",employee.getEmpid());
						s.setAttribute("name",employee.getName());
						s.setAttribute("email",employee.getEmail());
						s.setAttribute("password",employee.getPassword());
						s.setAttribute("gender",employee.getGender());
						s.setAttribute("number",employee.getMobileNumber());
						s.setAttribute("dept",employee.getDepartment());
						s.setAttribute("salary",employee.getSalary());
						s.setAttribute("Emprequest",employee.getRequest());	
					}
					response.sendRedirect("homepage.html");
				}else {
					LOGGER.info("Employee record not found");
					out.println("<script>alert('Employee Record not found');window.location.href='index.jsp';</script>");
				}
			}
			else if(role.equalsIgnoreCase("manager")) {
				LOGGER.info("Inside Manager Block");	
				
				boolean isManager= true;
				boolean isWorking= true;
				emp.setEmail(email);
				emp.setPassword(password);
				emp.setManager(isManager);
				emp.setWorking(isWorking);
				
				IManagerService managerObj = new ManagerServiceImpl();
				List<Employee> resultEmployee = managerObj.getManagerUser(emp);
				if(resultEmployee.size()==1) {
					LOGGER.info("Manager User Login Operation Successful...");
					s.setAttribute("employee",resultEmployee);
					out.println(resultEmployee);
					for (Employee employee : resultEmployee) {
						s.setAttribute("id",employee.getEmpid());
						s.setAttribute("name",employee.getName());
						s.setAttribute("email",employee.getEmail());
						s.setAttribute("password",employee.getPassword());
						s.setAttribute("gender",employee.getGender());
						s.setAttribute("number",employee.getMobileNumber());
						s.setAttribute("dept",employee.getDepartment());
						s.setAttribute("salary",employee.getSalary());
						s.setAttribute("Emprequest",employee.getRequest());
					}
					response.sendRedirect("ManagerHomePage.html");
				}else {
					out.println("<script>alert('Manager Record not found');window.location.href='index.jsp';</script>");
				}
			}
		    else {
		    	LOGGER.info("User Role Not found");
				out.println("<script>alert('Please Select User Role');window.location.href='index.jsp';</script>");
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
	}

}
