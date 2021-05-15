package datadriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) throws SQLException {
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt","root","root");
		Statement s = connect.createStatement();
		ResultSet rs = s.executeQuery("select * from testing");

		while(rs.next()){
		System.out.println(rs.getString("name"));

		}
	}
}
