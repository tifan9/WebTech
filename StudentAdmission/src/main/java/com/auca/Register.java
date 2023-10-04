package com.auca;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/register")
public class Register extends HttpServlet{
	
	private static final long serialVersionUID = 1;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException{
		try {
			String firstName = req.getParameter("fname");
	        String lastName = req.getParameter("lname");
	        String email = req.getParameter("email");
	        String phoneNumber = req.getParameter("phone");
	        String address = req.getParameter("address");
	        String gender = req.getParameter("gender");
	        int age = Integer.parseInt(req.getParameter("age"));
	        Part profilePicture = req.getPart("profile");
	        Part diploma = req.getPart("diploma");
	        
	        res.setContentType("text/html");
	        PrintWriter out = res.getWriter();
	        out.println("hello");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
}
