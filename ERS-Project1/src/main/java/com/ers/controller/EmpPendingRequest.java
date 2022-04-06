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

import com.ers.model.Request;

@SuppressWarnings("serial")
public class EmpPendingRequest extends HttpServlet implements Serializable{
	private static final Logger LOGGER = Logger.getLogger(EmpPendingRequest.class);
	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 LOGGER.info("Class @EmpPendingRequest Method @service");
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.println("<link href='main.css' rel='stylesheet'>");
		 out.println("Your Pending Request : ");
		 HttpSession session  = request.getSession();
		 List<Request> r = (List<Request>) session.getAttribute("Emprequest");
		 int count=0;
		 if(!r.isEmpty()) {
			 out.println("<table><tr><th>Request Type </th> <th>Amount </th> <th>Submitted On </th> </tr>");
		LOGGER.info("Class @EmpPendingRequest Print Employee Pending Request");	 
		 for (Request request2 : r) {
			if(!request2.isReqStatus()) {
				count++;
				out.println("<tr><td>"+request2.getType()+"</td>");
				out.println("<td>"+request2.getAmount()+"</td>");
				out.println("<td>"+request2.getSubmitdate()+"</td></tr>");
			} 
		}
		 out.println("</table>");
		 if(count==0) {
				out.println("No Pending Request Available");
		}
		 }else {
			 out.println("Not Any Request Submitted by "+session.getAttribute("name"));
		 }
	}

}
