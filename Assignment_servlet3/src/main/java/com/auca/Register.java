package com.auca;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



@WebServlet("/RegisterFilter")
@MultipartConfig
public class Register extends HttpServlet{
	private static final long serialVersionUID = 1;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			HttpSession session = req.getSession();
			session.setAttribute("firstname", req.getParameter("fname"));
			session.setAttribute("lastname", req.getParameter("lname"));
	        session.setAttribute("email",req.getParameter("email"));;
	        Part profilePicture = req.getPart("profile");
	        Part diploma = req.getPart("diploma");
	        
	        
	        if(!isValid(profilePicture, "images/jpg", "images/png")|| 
					!isValid(diploma, "application/pdf")) {
	        	String uploadDir = "/home/tifan/eclipse-workplace/uploads";
	        	
	        	File uploadDirectory = new File(uploadDir);
	        	if (!uploadDirectory.exists()) {
                    uploadDirectory.mkdirs(); 
                }
	        	File profilePictureFile = new File(uploadDir,"profile_picture.jpg");
		        File certificateFile = new File(uploadDir,"certificate.pdf");
		        
		        profilePicture.write(profilePictureFile.getAbsolutePath());
				diploma.write(certificateFile.getAbsolutePath());
				
				
				PrintWriter out=res.getWriter();
				out.println("Your Application was saved Successfull");
				
			}else {
				res.getWriter().write("only JPG, PNG and PDF allowed!");
				return;
			}
	        
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	// Check if the uploaded files are valid
	public boolean isValid(Part part, String...allowedContentTypes) {
		String contentType = part.getContentType();
		for(String allowedType : allowedContentTypes) {
			if(contentType.equals(allowedType)) {
				return true;
			}
		}
		return false;
	}
}
