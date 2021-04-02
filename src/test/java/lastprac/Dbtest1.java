package lastprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dbtest1 {
	
	@DataProvider(name="test")

	public Object[][] summa() throws SQLException {
		// TODO Auto-generated method stub
		Object[][] test = new Object[2][2];
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt","root","root");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("Select * from testing where name = 'naveen1'");
		while(rs.next()) {
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					test[i][j] = rs.getString("name");
					++j;
					test[i][j] = rs.getString("age");
				}
			}
		}
		
		return test;
	}
	
	@Test(dataProvider="test")
	public void test(String arg1, String arg2)
	{
		System.out.println(arg1+arg2);
	}

}
