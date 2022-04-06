package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ers.model.Request;
import com.ers.service.IManagerService;
import com.ers.service.ManagerServiceImpl;


@SuppressWarnings("serial")
public class RequestApproved extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(RequestApproved.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("class @RequestApproved Inside Method @doGet Request Approved");
		String id = request.getParameter("reqid");
		Integer reqid= Integer.parseInt(id);
		PrintWriter out = response.getWriter();
		out.println("get id "+reqid);
		Request req = new Request();
		req.setReqid(reqid);
		IManagerService managerObj = new ManagerServiceImpl();
		boolean isApproved = managerObj.approvedRequest(req);
		if(isApproved) {
			LOGGER.info("class @ReqestApproved => Request Approved");
			out.println("<script>alert('Employee request Approved');</script>");
			RequestDispatcher rd=request.getRequestDispatcher("ViewAllRequest");
			rd.include(request, response);
			rd.forward(request, response);
		}else {
			LOGGER.info("class @RequestApproved => Internal Error occur");
			out.println("Integer Error occur");
		}
		
	}

}
