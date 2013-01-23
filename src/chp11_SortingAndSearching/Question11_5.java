package chp11_SortingAndSearching;

/*
 * Given a sorted array of strings which is 
 * interspersed with empty strings, 
 * write a method to find the location of a given string.
 */
public class Question11_5 {

	static int findStr(String[] strs, String str, int left, int right) {
		if(left > right) return -1;
		
		int middle = (left + right) / 2;
		if(strs[middle].equals("")) {
			int mLeft = middle - 1;
			int mRight = middle + 1;
			while(true) {
				if(mLeft < left || mRight > right)
					return -1;
				
				if(!strs[mLeft].equals("")) {
					middle = mLeft;
					break;
				}
				if(!strs[mRight].equals("")) {
					middle = mRight;
					break;
				}
				mLeft++;
				mRight++;
			}
		}
		
		if(strs[middle].compareTo(str) > 0)
			return findStr(strs, str, left, middle - 1);
		else if(strs[middle].compareTo(str) == 0)
			return middle;
		else return findStr(strs, str, middle + 1, right);
	}
	
	public static void main(String[] args) {
		String[] strs = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		System.out.println(findStr(strs, "at", 0, strs.length - 1));
		System.out.println(findStr(strs, "dad", 0, strs.length - 1));
		System.out.println(findStr(strs, "ballcar", 0, strs.length - 1));
	}
}
