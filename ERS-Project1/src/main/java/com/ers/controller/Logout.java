package com.ers.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Logout
 */
@SuppressWarnings("serial")
public class Logout extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(Logout.class);
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("class @Logout Inside  method @Service ");
		HttpSession session = request.getSession();
		session.invalidate();
		LOGGER.info("Inside Method @service Session Invalidate Logout");
		response.sendRedirect("index.jsp");
		
	}

}
