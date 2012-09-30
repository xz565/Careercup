package Interview;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<String> strs = new ArrayList<String>();
		strs.add("1");
		strs.add("2");
		strs.add("3");
		System.out.println(strs);
		
		double d1 = 0.4;
		double d3 = 0.2;
		double d2 = 0.8;
		double d4 = 0.4;
		System.out.println(Math.abs(d1 / d3));
		System.out.println(Math.abs(d2 / d4));
		System.out.println("d1 == d2 ? " + (Math.abs(d1 / d3) == Math.abs(d2 / d4)));
	}
}
