package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ers.model.Employee;
import com.ers.model.Request;
import com.ers.service.EmployeeServiceImpl;
import com.ers.service.IEmployeeService;

@SuppressWarnings("serial")
public class SubmitRequest extends HttpServlet implements Serializable{
	private static final Logger LOGGER = Logger.getLogger(SubmitRequest.class);
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("class @SubmitRequest inside Method @doGet ");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link href='main.css' rel='stylesheet'>");
		String type= request.getParameter("reimbursementType");
		Integer amount = Integer.parseInt(request.getParameter("amount")); 
		HttpSession session = request.getSession();
		
		
		Employee empDetail = new Employee();
		empDetail.setEmpid((Integer)session.getAttribute("id"));
		empDetail.setName((String)session.getAttribute("name"));
		empDetail.setEmail((String)session.getAttribute("email"));
		empDetail.setPassword((String)session.getAttribute("password"));
		empDetail.setGender((String)session.getAttribute("gender"));
		empDetail.setMobileNumber((String)session.getAttribute("number"));
		empDetail.setDepartment((String)session.getAttribute("department"));
		empDetail.setSalary((Integer)session.getAttribute("salary"));
		empDetail.setRequest((List<Request>)session.getAttribute("Emprequest"));
	
		Request emprequest = new Request();
		emprequest.setType(type);
		emprequest.setAmount(amount);
		emprequest.setReqStatus(false); // by default pending state => after manager action it will be resolved
		emprequest.setApproved(false);   // by default its not on approved
		emprequest.setSubmitdate(new Date());
		emprequest.setEmployee(empDetail);
		out.println(type+" "+amount+" "+session.getAttribute("id"));
		
		IEmployeeService employeeObj = new EmployeeServiceImpl();
		boolean isRequestSubmit = employeeObj.submitRequest(emprequest);
		if(isRequestSubmit) {
			LOGGER.info("@SubmitRequest Request Submit Successfully");
			out.println("Your Request Submitted Successfully!....");
			out.println("<a href='homepage.html'>Go to Home page</a>");
		}else {
			out.println("Sorry! Internal Server Error");
		}

	}

}
