package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet 
{
	public void service (HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println ("<html><body><h1>Hello World!</h1>");
		out.println ("Time : " + new Date() + "</body></html>");

		out.close();
	}
}
