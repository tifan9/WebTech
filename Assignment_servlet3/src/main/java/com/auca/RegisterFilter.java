package com.auca;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class RegisterFilter
 */
@WebFilter("/RegisterFilter")
public class RegisterFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse res= (HttpServletResponse) response;
		HttpSession session=req.getSession(false);
		 try {
			 if(session !=null) {
				 String mail=(String)session.getAttribute("email");
				 if(mail !=null && !mail.isEmpty() ) {
					 chain.doFilter(request, response);
				 }else {
					 res.sendRedirect("/signup.html");
				 }
			 }else {
				 res.sendRedirect("/signup.html");
			 }
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	     
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
