package datadriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SummaTest {
	@Test(dataProvider="test")
	public void testing(String name , String name1){
	System.out.println(name);
	System.out.println(name1);
	}


	@DataProvider(name="test")
	public Object[][] test(){
	Object[][] name = new Object[2][2];
	name[0][0] = "naveen";
	name[0][1] = "naveen1";
	name[1][0] = "naveen2";
	name[1][1] = "naveen3";
	return name;
	}


}
