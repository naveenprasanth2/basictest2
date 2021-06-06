package practise2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class JavaPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"naveen","prasanth","summa","summa1","summa"};
		Queue<String> qu = new PriorityQueue<String>();
		qu.add("test");
		qu.add("test1");
		qu.addAll(Arrays.asList(a));
		System.out.println(qu);
		System.out.println(qu);
	}

}
