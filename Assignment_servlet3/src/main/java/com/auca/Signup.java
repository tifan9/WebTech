package com.auca;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Signup")
public class Signup extends HttpServlet{
	private static final long serialVersionUID = 1;
	
	public static final String usermail = "sophie@mail.com";
	public static final String password = "123";
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException{
		try {
			HttpSession session= req.getSession();
			String user= req.getParameter("email");
			String pswd= req.getParameter("password");
			session.setAttribute(user, pswd);
			PrintWriter out = res.getWriter();
			// check if the entered input matches
			if(usermail.equals(user) && password.equals(pswd)) {
				res.sendRedirect("index.html");
			}else {
				out.println( "invalid Email and Password");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
