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

import com.ers.model.Request;
import com.ers.service.IManagerService;
import com.ers.service.ManagerServiceImpl;

@SuppressWarnings("serial")
public class ViewAllPendingRequest extends HttpServlet implements Serializable {
	private static final Logger LOGGER = Logger.getLogger(ViewAllPendingRequest.class);
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("class @ViewAllRequest inside method @Service");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link href='main.css' rel='stylesheet'>");
		Request requestObj = new Request();
		LOGGER.info("class @ViewAllRequest inside method @Service getAllRequest method call ...");
		IManagerService managerObj = new ManagerServiceImpl();
		List<Request> allrequest = managerObj.getAllRequest(requestObj);
		if(!allrequest.isEmpty()) {
			out.println("<table><tr><th>Request type</th> <th>Amount</th>  <th>Employee Name</th> <th> Email</th> <th>MobileNo</th> <th>Department</th> <th>Salary</th><th> Submitted On</th> <th> Approved </th> </tr>");
			for (Request request2: allrequest) {
				if(!request2.isApproved())
				{
				out.println("<tr> <td>"+request2.getType() +"</td>");
				out.println("<td>"+request2.getAmount()+"</td>");
				out.println("<td>"+request2.getEmployee().getName()+"</td>");
				out.println("<td>"+request2.getEmployee().getEmail()+"</td>");
				out.println("<td>"+request2.getEmployee().getMobileNumber()+"</td>");
				out.println("<td>"+request2.getEmployee().getDepartment()+"</td>");
				out.println("<td>"+request2.getEmployee().getSalary()+"</td>");
				out.println("<td>"+request2.getSubmitdate()+"</td>");
				out.println("<td><a class='link-button' href=RequestApproved?reqid="+request2.getReqid()+">"+change(request2.isApproved())+"</a></td>");
				//out.println("<td><a class='link-button' href=RequestResolved?reqid="+request2.getReqid()+">"+changeWords(request2.isReqStatus())+"</a></td></tr>");
			    }
			}
			out.println("</table>");
			
			
		}else {
			out.println("<h3>No Request Available</h3>");
		}
	}

	private String change(boolean approved) {
		if(approved) {
			return "Yes";
		}
		else {
			return "No";
		}
	}
}
