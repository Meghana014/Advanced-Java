package pack1;

import java.io.IOException;
 
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/hello")
public class MyFirstSevlet implements Servlet {

    public MyFirstSevlet() {
    }

	public void init(ServletConfig config) throws ServletException {
	System.out.println("hello init method");
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
         System.out.println("hello service method");
	}

}
