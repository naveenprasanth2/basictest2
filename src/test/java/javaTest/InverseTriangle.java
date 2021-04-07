package javaTest;

import java.util.ArrayList;

public class InverseTriangle {
	
	public static void main (String[] args) {
		String ipAddress = "192.168.3.72";
		String[] ip = ipAddress.split("[.]");

		ArrayList<Integer> test = new ArrayList<Integer>();

		for(int i=0;i<ip.length;i++) {
			test.add(Integer.parseInt(ip[i]));
		}

		int sizeofarray = 0;
		for(Integer data: test) {
			if(data<=255) {
				sizeofarray++;
			}
			else {
				System.out.println("entered ip address is not valid");
				break;
			}
		}
		if(sizeofarray==test.size()) {
			System.out.println("entered ip address is valid");
		}
		
	}

}
