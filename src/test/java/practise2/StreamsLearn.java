package practise2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StreamsLearn {

	public static void main(String[] args) {
		String[] a = { "name", "phone", "address", "pincode", "summa" };
		String[] b = { "naveen", "44465464", "annanagar", "637211", "summavalue" };
		ArrayList<Map.Entry<String, String>> test = new ArrayList<Map.Entry<String, String>>();
		for (int i = 0; i < a.length; i++) {
			test.add(Map.entry(a[i], b[i]));
		}
		System.out.println(test);
		HashMap<String, String> test1 = new HashMap<String, String>();
		for(Entry<String,String> summa : test) {
			test1.put(summa.getKey(), summa.getValue());
		}
		System.out.println(test1);
	}
}
