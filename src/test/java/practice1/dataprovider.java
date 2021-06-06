package practice1;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
	@Test(dataProvider="data3")
	public void test(HashMap<String,String> test) {
		System.out.println(test.get("name"));
		System.out.println(test.get("phone"));
		System.out.println(test.get("location"));
		System.out.println(test.get("product"));
		
	}
	@DataProvider
	public static Object[][] data1(){
	Object[][] o = new Object[1][];
	HashMap<String,String> test = new HashMap<String,String>();
	test.put("name","naveen");
	test.put("phone","65445645644");
	o[0] = new Object[] {test};
	return o;
	}

	@DataProvider
	public static Object[][] data2(){
	Object[][] o = new Object[1][];
	HashMap<String,String> test = new HashMap<String,String>();
	test.put("location","tiruchengode");
	test.put("product","computer");
	o[0] = new Object[] {test};
	return o;
	}
	
	@SuppressWarnings("unchecked")
	@DataProvider
	public static Object[][] data3(){
	Object[][] o = new Object[1][];
	HashMap<String,String> test = new HashMap<String,String>();
	test.putAll((HashMap<String,String>) data1()[0][0]);
	test.putAll((HashMap<String,String>) data2()[0][0]);
	o[0] = new Object[] {test};
	return o;
	}
}
