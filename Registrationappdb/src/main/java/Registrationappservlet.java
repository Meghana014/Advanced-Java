

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class Registrationappservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Registrationappservlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter pw=response.getWriter();
            
            String id=request.getParameter("id");
            int id1=Integer.parseInt(id);
            
            String firstName=request.getParameter("firstname");
            String lastName=request.getParameter("lastname");
            String userName=request.getParameter("username");
            String password=request.getParameter("password");
            
            try
            {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
            	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
            	String s="insert into registration values(?,?,?,?,?)";
            	
            	PreparedStatement p=con.prepareStatement(s);
            	 p.setInt(1, id1);
            	 p.setString(2, firstName);
            	 p.setString(3, lastName);
            	 p.setString(4, userName);
            	 p.setString(5, password);
            	
            	int i= p.executeUpdate();
            	 
            	 if(i>0)
            	 {
            		 pw.print("successfully registered");
            	 }
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
            
	
	}

}
