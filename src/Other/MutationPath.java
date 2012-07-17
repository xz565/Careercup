package Other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
 * An interview question of Epic
 */
public class MutationPath {

	public static HashMap<String, String> findPath(String startWord, String endWord) {
		if(startWord.length() != endWord.length()) return null;
		ArrayList<String> queue = new ArrayList<String>();
		HashSet<String> visited = new HashSet<String>();
		HashMap<String, String> traceWords = new HashMap<String, String>();
		
		queue.add(startWord);
		visited.add(startWord);
		
		while(!queue.isEmpty()) {
			String currt = queue.remove(0);
			for(String str : mutation(currt)) {
				if(!visited.contains(str)) {
					traceWords.put(str, currt);
					if(str.equals(endWord)) return traceWords;
					else {
						queue.add(str);
						visited.add(str);
					}
				}
			}
		}
		return null;
	}
	
	public static ArrayList<String> mutation(String str) {
		char[] charStr = str.toCharArray();
		ArrayList<String> mutations = new ArrayList<String>();
		for(int i = 0; i < charStr.length - 1; i++) {
			char[] cloneCharStr = charStr.clone();
			char currtChar = cloneCharStr[i];
			cloneCharStr[i] = cloneCharStr[i + 1];
			cloneCharStr[i + 1] = currtChar;
			mutations.add(new String(cloneCharStr));
		}
		return mutations;
	}
	
	public static void main(String[] args) {
		String start = "qwertyuiop";
		String end = "poiuytrewq";
		
		long startTime = System.currentTimeMillis();
		HashMap<String, String> path = findPath(start, end);
		long endTime = System.currentTimeMillis();
		
		String next = path.get(end);
		System.out.print(end + "\n");
		while(next != null) {
			System.out.print(next + "\n");
			next = path.get(next);
		}
		System.out.println(path.size());
		System.out.println(endTime - startTime);
	}
}
