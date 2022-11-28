package reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reg")
public class RegSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegSaveServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response page and getting writer object
		response.setContentType("html/text");
		PrintWriter pw = response.getWriter();
		// getting req parameters from ui by using req obj
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String userName = request.getParameter("uname");
		String password = request.getParameter("pass");
		String dateOfBirth = request.getParameter("dob");
		String PhoneNumber = request.getParameter("phone");
		long PhoneNumber1 = Long.parseLong(PhoneNumber);
		String age = request.getParameter("age");
		int age1 = Integer.parseInt(age);

		// connect to the db
		// loading the driver class
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
			PreparedStatement pstmt = con.prepareStatement("insert into registrationinfo values(?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, id1);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, userName);
			pstmt.setString(5, password);
			pstmt.setString(6, dateOfBirth);
			pstmt.setLong(7, PhoneNumber1);
			pstmt.setInt(8, age1);

			int status = pstmt.executeUpdate();
			if (status > 0) {
				pw.print("<html><body bg color='pink'><h1>you are successfully registered</h1></body></html>");
			} else {
				pw.print("<html><body bg color='light blue'><h1>not registred ");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
