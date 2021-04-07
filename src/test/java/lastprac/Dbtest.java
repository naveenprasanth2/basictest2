package lastprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbtest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt","root","root");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from testing");

		while(rs.next()){
		System.out.println(rs.getString("name"));
		}
	}
}
