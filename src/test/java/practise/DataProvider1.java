package practise;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	@Test(dataProvider="data3")
	public void test(HashMap<String,String> test) {

		System.out.println(test);
	}

	@DataProvider(name = "data1")
	public Object[][] data1(){
	Object[][] o = new Object[1][];
	HashMap<String,String> dp1 = new HashMap<String,String>();
	dp1.put("name","naveen");
	dp1.put("phone","49897987897");

	o[0] = new Object[] {dp1};
	return o;

	}

	@DataProvider(name = "data2")
	public Object[][] data2(){
	Object[][] o = new Object[1][];
	HashMap<String,String> dp2 = new HashMap<String,String>();
	dp2.put("city","chennai");
	dp2.put("landline","illlayae");

	o[0] = new Object[] {dp2};
	return o;

	}

	
	@SuppressWarnings("unchecked")
	@DataProvider(name = "data3")
	public Object[][] data3(){
	Object[][] o = new Object[1][];
	HashMap<String,String> dp3 = new HashMap<String,String>();
	dp3.putAll((HashMap<String,String>) data1()[0][0]);
	dp3.putAll((HashMap<String,String>) data2()[0][0]);
	o[0] = new Object[] {dp3};
	return o;

	}
}
