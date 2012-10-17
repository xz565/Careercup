package Interview;

public class Pascal {

	public static long[] pascal(int level) {
		if(level <= 0) return null;
		if(level == 1) return new long[1];
		
		long[] lastLevel = pascal(level - 1);
		long[] curtLevel = new long[level];
		
		for(int i = 0; i < level; i++) {
			if(i == 0 || i == level - 1) curtLevel[i] = 1;
			else curtLevel[i] = lastLevel[i - 1] + lastLevel[i];
		}
		
		return curtLevel;
	}
	
	public static void main(String[] args) {
		long[] result = pascal(40);
		for(int i = 0; i < result.length; i++){
			System.out.println(result[i]);
		}
	}
}
