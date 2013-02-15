package chp11_SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Question11_7 implements Comparator<People>{

	@Override
	public int compare(People o1, People o2) {
		if(o1.height > o2.height) return 1;
		else if(o1.height < o2.height) return -1;
		else return 0;
	}

	static int computeNum(People[] peoples) {
		// sort by height
		sortByHeight(peoples);
		
		// find largest subset by weight
		return findLargestSubset(peoples);
	}
	
	static void sortByHeight(People[] ps) {
		Arrays.sort(ps, new Question11_7());
	}
	
	static int findLargestSubset(People[] ps) {
		int maxLen = 0;
		int currtLen = 0;
		int prevWeight = 0;
		
		for (int i = 0; i < ps.length; i++) {
			int w = ps[i].weight;
			
			if(w > prevWeight) {
				currtLen++;
			} else {
				if(currtLen > maxLen)
					maxLen = currtLen;
				currtLen = 1;
			}
			prevWeight = w;
		}
		
		return currtLen > maxLen ? currtLen : maxLen;
	}
	
	
	// another solution recursively
	public static ArrayList<People> findLargestR(People[] peoples, People bottom) {
		int maxHeight = 0;
		ArrayList<People> maxTower = null;
		
		for(People p : peoples) {
			if(p.canBeAbove(bottom)) {
				ArrayList<People> newTower = findLargestR(peoples, p);
				int newHeight = newTower.size();
				if(newHeight > maxHeight) {
					maxHeight = newHeight;
					maxTower = newTower;
				}
			}
		}
		
		if(maxTower == null)
			maxTower = new ArrayList<People>();
		
		maxTower.add(0, bottom);
		
		return maxTower;
	}
	
	
	public static ArrayList<People> findLargestDP(
			People[] peoples, People bottom, HashMap<People, ArrayList<People>> map) {
		if(map.containsKey(bottom))
			return (ArrayList<People>)map.get(bottom).clone();
		
		int maxHeight = 0;
		ArrayList<People> maxTower = null;
		
		for(People p : peoples) {
			if(p.canBeAbove(bottom)) {
				ArrayList<People> newTower = findLargestDP(peoples, p, map);
				int newHeight = newTower.size();
				if(newHeight > maxHeight) {
					maxHeight = newHeight;
					maxTower = newTower;
				}
			}
		}
		
		if(maxTower == null)
			maxTower = new ArrayList<People>();
		
		maxTower.add(0, bottom);
		map.put(bottom, maxTower);
		
		return (ArrayList<People>)maxTower.clone();
	}
	
	public static void main(String[] args) {
		/*
		People[] ps = {new People(65, 100), new People(70, 150), new People(56, 90), new People(75, 190), 
				new People(60, 95), new People(68, 110), new People(20, 100)};
		*/
		final int max = 100;
		People[] ps = new People[max];
		for(int i = 0; i < max; i++) {
			ps[i] = new People((int)(100*Math.random()%100), (int)(100*Math.random()%100));
		}
		
		long startTime = System.currentTimeMillis();
		System.out.println("Max Height " + computeNum(ps));
		long endTime = System.currentTimeMillis();
		System.out.println("Time:" + (endTime - startTime));
		System.out.println();
		
		startTime = System.currentTimeMillis();
		ArrayList<People> maxTower = findLargestR(ps, new People(Integer.MAX_VALUE, Integer.MAX_VALUE));
		endTime = System.currentTimeMillis();
		System.out.println("Max Height " + maxTower.size());
		System.out.println("Time:" + (endTime - startTime));
		for(People p : maxTower) System.out.println(p);
		System.out.println();
		
		HashMap<People, ArrayList<People>> map = new HashMap<People, ArrayList<People>>();
		startTime = System.currentTimeMillis();
		maxTower = null;
		maxTower = findLargestDP(ps, new People(Integer.MAX_VALUE, Integer.MAX_VALUE), map);
		endTime = System.currentTimeMillis();
		System.out.println("Max Height " + maxTower.size());
		System.out.println("Time:" + (endTime - startTime));
		for(People p : maxTower) System.out.println(p);
		//System.out.println(map.keySet().size());
		
	}
}

class People {
	int height;
	int weight;
	
	public People(int h, int w) {
		height = h;
		weight = w;
	}

	public boolean canBeAbove(People p) {
		return this.height < p.height && this.weight < p.weight;
	}
	
	public String toString() {
		return "P:(" + height + " " + weight + ")" + " ";
	}
}