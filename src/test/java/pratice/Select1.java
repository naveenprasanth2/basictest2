package pratice;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Select1 {
	@Test(dataProvider="test")
	public void test(String test , String test1) throws InterruptedException, IOException, SQLException {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt","root","root");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from testing where name='naveen'");
		while(rs.next()) {
			System.out.println(rs.getString("name"));

		}
System.out.println(test);
System.out.println(test1);
	}
	
	@DataProvider(name="test")
	public Object[][] summa(){
		Object[][] test = new Object[2][2];
		test[0][0] = "naveendata";
		test[0][1] = "prasanthdata";
		test[1][0] = "naveen d1";
		test[1][1] = "naveen d2";
		return test;
	}
}
