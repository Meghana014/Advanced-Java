

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cal")
public class calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public calculator() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
         String a1=request.getParameter("n1");
         String a2=request.getParameter("n2");
         
         int n1=Integer.parseInt(a1);
         int n2=Integer.parseInt(a2);
         
         String option=request.getParameter("cal");
         
        switch(option)
        {
        case "add" :
     	   pw.println("<html><body bgcolor='skyblue'><h1 style='text-align:center'>Addition</h1></body></html>"+(n1+n2));
           break;
        case "sub" :
     	   pw.println("<html><body bgcolor='skyblue' ><h1>Subtraction</h1></body></html>"+(n1-n2));
           break;
        case "mul" :
     	   pw.println("<html><body bgcolor='green' ><h1>multiplication</h1></body></html>"+(n1*n2));
           break;
        case "div" :
     	   pw.println("<html><body bgcolor='green' ><h1>Division</h1></body></html>"+(n1/n2));
        }
	}

}
