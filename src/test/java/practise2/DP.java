package practise2;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP {
	@Test(dataProvider="data3")
	public void test(HashMap<String,String> test){
	System.out.println(test.get("name"));
	System.out.println(test.get("phone"));
	System.out.println(test.get("address"));
	System.out.println(test.get("summa"));
	}

	@DataProvider(name="data1")
	public Object[][] data1(){
	Object[][] o = new Object[1][];
	HashMap<String,String> test = new HashMap<String,String>();
	test.put("name","naveen");
	test.put("phone","87879798797");
	o[0] = new Object[] {test};
	return o;
	}

	@DataProvider(name="data2")
	public Object[][] data2(){
	Object[][] o = new Object[1][];
	HashMap<String,String> test = new HashMap<String,String>();
	test.put("address","anna nagar");
	test.put("summa","summa tha");
	o[0] = new Object[] {test};
	return o;
	}
	
	@SuppressWarnings("unchecked")
	@DataProvider(name="data3")
	public Object[][] data3(){
	Object[][] o = new Object[1][];
	HashMap<String,String> test = new HashMap<String,String>();
	test.putAll((HashMap<String,String>) data1()[0][0]);
	test.putAll((HashMap<String,String>) data2()[0][0]);
	o[0] = new Object[] {test};
	return o;
	}

}
