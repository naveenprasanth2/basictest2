package intervew;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderDemo {
	@Test(dataProvider="data3")
	public void test(HashMap<String,String> test) {
		System.out.println(test.get("name"));
		System.out.println(test.get("lastname"));
		System.out.println(test.get("phone"));
		System.out.println(test.get("landline"));
	}
	@DataProvider(name="data1")
	public static Object[][] data1(){
	Object[][] o = new Object[1][];
	HashMap<String,String> test = new HashMap<String,String>();
	test.put("name","naveen");
	test.put("lastname","prasanth");
	o[0] = new Object[] {test};
	return o;
	}

	@DataProvider(name="data2")
	public static Object[][] data2(){
	Object[][] o = new Object[1][];
	HashMap<String,String> test = new HashMap<String,String>();
	test.put("phone","2598798797");
	test.put("landline","value");
	o[0] = new Object[] {test};
	return o;
	}

	@SuppressWarnings("unchecked")
	@DataProvider(name="data3")
	public static Object[][] data3(){
	Object[][] o = new Object[1][];
	HashMap<String,String> test = new HashMap<String,String>();
	test.putAll((HashMap<String,String>) data1()[0][0]);
	test.putAll((HashMap<String,String>) data2()[0][0]);
	o[0] = new Object[] {test};
	return o;
	}
}
