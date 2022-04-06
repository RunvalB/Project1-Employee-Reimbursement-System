package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import com.ers.exception.NoEmployeeResultFound;
import com.ers.model.Employee;
import com.ers.model.Request;

import com.ers.service.IManagerService;
import com.ers.service.ManagerServiceImpl;

@SuppressWarnings("serial")
public class ViewSpecificEmployee extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(ViewSpecificEmployee.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("class @ViewSpecificEmmployee inside method @doGet View Specidific Employee Detail");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link href='main.css' rel='stylesheet'>");
		String email = request.getParameter("empEmail");
		Employee empObj = new Employee();
		empObj.setEmail(email);
		LOGGER.info("Calling Method EmployeeServiceImpl");
		IManagerService emp = new ManagerServiceImpl();
		Employee empDetail;
		try {
			empDetail = emp.getSpecificEmployeeDetail(empObj);
			if(empDetail != null) {
				out.println("<table><tr><th>Employee Name</th><th>Department</th><th>Salary</th><th>Request Type</th><th>Amount</th><th>Submitted On</th></tr>");
				List<Request> requets = empDetail.getRequest();
		        for (Request request2 : requets) {
		        	out.println("<tr><td>"+empDetail.getName()+"</td>");
					out.println("<td>"+empDetail.getDepartment()+"</td>");
					out.println("<td>"+empDetail.getSalary()+"</td>");
		        	out.println("<td>"+request2.getType()+"</td>");
		        	out.println("<td>"+request2.getAmount()+"</td>");
		        	out.println("<td>"+request2.getSubmitdate()+"</td></tr>");
				}
		        out.println("</table>");
			}else if(empDetail == null) {
				throw new  NoEmployeeResultFound("No Result Found");
			}
		} catch (NoEmployeeResultFound e) {
			LOGGER.info("No User Data found in @ViewSpecificEmployee class");
			out.println("<script> alert('No Record Found'); window.location.href='ViewSpecificEmployee.html';</script>");
		}	
	}

}
