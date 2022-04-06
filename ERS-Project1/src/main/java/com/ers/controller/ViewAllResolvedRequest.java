package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
public class ViewAllResolvedRequest extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(ViewAllResolvedRequest.class);
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("class @ViewAllResolvedRequest inside method @service for View All Resolved Request");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link href='main.css' rel='stylesheet'>");
		Request requestObj = new Request();
		LOGGER.info("class @ViewAllResolvedRequest Service call for DAO");
		IManagerService managerObj = new ManagerServiceImpl();
		List<Request> allrequest = managerObj.getAllRequest(requestObj);
		if(!allrequest.isEmpty()) {
			LOGGER.info("Printing All Resolved Request");
			out.println("<table><tr><th>Request type</th> <th>Amount</th>  <th>Employee Name</th> <th> Email</th> <th>MobileNo</th> <th>Department</th> <th>Salary</th><th> Request Status </th> </tr>");
			for (Request request2: allrequest) {
				if(request2.isReqStatus()) {
				out.println("<tr> <td>"+request2.getType() +"</td>");
				out.println("<td>"+request2.getAmount()+"</td>");
				out.println("<td>"+request2.getEmployee().getName()+"</td>");
				out.println("<td>"+request2.getEmployee().getEmail()+"</td>");
				out.println("<td>"+request2.getEmployee().getMobileNumber()+"</td>");
				out.println("<td>"+request2.getEmployee().getDepartment()+"</td>");
				out.println("<td>"+request2.getEmployee().getSalary()+"</td>");
				out.println("<td><a class='link-button' href=?reqid="+request2.getReqid()+">"+changeWords(request2.isReqStatus())+"</a></td></tr>");
			}
			}
			out.println("</table>");
			
		}else {
			LOGGER.info("No Request Found");
			out.println("<h3>No Request Available</h3>");
		}
	}
	
	private String changeWords(boolean reqStatus) {
		if(reqStatus) {
			return "Resolved";
		}else {
			return "Pending";
		}
	}


}
