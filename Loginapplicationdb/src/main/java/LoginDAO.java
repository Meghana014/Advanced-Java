import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
  public static boolean validateUserDetails(String userName,String password) throws ClassNotFoundException, SQLException
  {
	 boolean status=false;  
	 
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 
	 
	  System.out.println("before");
	 Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	 String s= "select * from studentinfo where userName=? and password=?";
	 System.out.println("after");
	 PreparedStatement p=c.prepareStatement(s);
	 p.setString(1,userName);
	 p.setString(2,password);
	 ResultSet r=p.executeQuery();
	 
	 status=r.next();
	 
	 return status;
	  
  }
}
