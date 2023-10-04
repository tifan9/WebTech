package com.auca;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Signup")
public class Signup extends HttpServlet{
	private static final long serialVersionUID = 1;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException{
		try {
			String user= req.getParameter("username");
			String pswd= req.getParameter("password");
			
			PrintWriter out = res.getWriter();
			res.setContentType("text/html");
			
			res.sendRedirect("index.html");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
