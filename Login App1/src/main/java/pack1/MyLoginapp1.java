package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class MyLoginapp1 implements Servlet {

    public MyLoginapp1() {
    }
	public void init(ServletConfig config) throws ServletException {
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		String username= request.getParameter("uname");
		String password=request.getParameter("pass");
		if(username.equalsIgnoreCase("meghana") && password.equals("meghana123"))
		{
			pw.println("<HTML><title>success page</title><body bgcolor='yellow'><H1>hello meghana login is successed</H1></body></HTML>");
		}
		else
		{
			pw.println("<HTML><title>unsuccess page</title><body bgcolor='green'>credentials are not correct try again</body></HTML>");
		}
		}

}
