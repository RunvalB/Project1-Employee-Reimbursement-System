package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ers.model.Request;

@SuppressWarnings("serial")
public class EmpResolvedRequest extends HttpServlet {
	
	private static final Logger LOGGER = Logger.getLogger(EmpResolvedRequest.class);
	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 LOGGER.info("class @EmpResolvedRequest Method @Service");
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.println("<link href='main.css' rel='stylesheet'>");
		 out.println("Your Resolved Request : ");
		 HttpSession session  = request.getSession();
		
		 boolean reqStatus = true;
		 int count = 0;
		 List<Request> r = (List<Request>) session.getAttribute("Emprequest");
		 if(!r.isEmpty()) {
			 out.println("<table><tr><th>Request Type </th> <th>Amount </th> <th>Submitted On </th> </tr>");
			LOGGER.info("Printing Resolved Request");
		 for (Request request2 : r) {
			if(request2.isReqStatus()== reqStatus) {
				count++;
				out.println("<tr><td>"+request2.getType()+"</td>");
				out.println("<td>"+request2.getAmount()+"</td>");
				out.println("<td>"+request2.getSubmitdate()+"</td></tr>");
			} 
		}
		 out.println("</table>");
		 if(count==0) {
					out.println("No Resolved Request Available");
		 }
		 }else {
			 out.println("Not Any Request Resolved by Manager!");
		 }
	
	}

}
