package Interview;

import java.util.HashMap;
import java.util.Stack;

public class StrIntConvt {

	public static int strToInt(String num) {
		int zeroAscii = 48;
		int restAscii = 57;
		int result = 0;
		
		for(char c : num.toCharArray()) {
			if(c >= zeroAscii && c <= restAscii) {
				result = result*10 + (c - zeroAscii);
			} else {
				return -1;
			}
		}
		
		return result;
	}
	
	public static String intToStr(int num) {
		StringBuffer sb = new StringBuffer();
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "0");		
		map.put(1, "1");
		map.put(2, "2");
		map.put(3, "3");
		map.put(4, "4");
		map.put(5, "5");
		map.put(6, "6");
		map.put(7, "7");
		map.put(8, "8");
		map.put(9, "9");
		
		Stack<String> stk = new Stack<String>();
		
		while(num > 0) {
			int leastBit = num % 10;
			stk.push(map.get(leastBit));
			num /= 10;
		}
		
		while(!stk.isEmpty()) sb.append(stk.pop());
		
		return sb.toString();
	}

	
	public static void main(String[] main) {
		System.out.println(strToInt("23456"));
		System.out.println(intToStr(456789));
	}
}
