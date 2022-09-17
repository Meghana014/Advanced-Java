package com.ks.one;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Myloginapp")
public class Myloginapp extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

  
    public Myloginapp() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		
	   if(username.equalsIgnoreCase("divyareddy") && password.equals("meghana12345"))
	   {
		   pw.println("<html><title>success page</title><body bgcolor='pink'><h1>hello meghana welcome</h1></body></html>");
	   }
	   else
	   {
		   pw.println("<html><title>unsuccess page</title><body bgcolor='yellow'><h1>invalid credentials</h1></body></html>");
	   }
	}

}
