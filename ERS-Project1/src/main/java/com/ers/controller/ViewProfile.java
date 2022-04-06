package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class ViewProfile extends HttpServlet implements Serializable{
	private static final Logger LOGGER = Logger.getLogger(ViewProfile.class);
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("class @ViewProfile inside method @service View Profile ");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		out.println(session.getAttribute("name"));
		out.println(session.getAttribute("email"));
		out.println(session.getAttribute("password"));
		out.println(session.getAttribute("gender"));
		out.println(session.getAttribute("number"));
		out.println(session.getAttribute("dept"));
		out.println(session.getAttribute("salary"));
		//out.println(session.getAttribute("Emprequest"));
		session.getAttribute("id");	
	}
}
