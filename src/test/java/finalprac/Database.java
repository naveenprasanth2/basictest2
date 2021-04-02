package finalprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Database {

	@Test
	public void test() throws SQLException {
		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt", "root", "root");
		Statement s = con.createStatement();
		ResultSet res = s.executeQuery("Select * from testing");
		while(res.next()) {
			System.out.println(res.getString("name"));
			System.out.println(res.getString("age"));
		}
		

	}
}
