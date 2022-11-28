package com.ks.one;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDBConnections {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//loading the driver class
		System.out.println("loading the driver class..");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//creating connection object
		System.out.println("creating connection object");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		//create statement
		System.out.println("creating statement object");
		Statement stmt=con.createStatement();
		//execute queries
		System.out.println("executing queries");
		ResultSet rs=stmt.executeQuery("select * from student");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getLong(4));
		}
		con.close();

	}

}
