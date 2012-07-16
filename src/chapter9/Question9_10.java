package chapter9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Question9_10 {
	
	static ArrayList<Box> buildTallest(Box[] boxes, Box bottom) {
		int maxHeight = 0;
		ArrayList<Box> maxStack = null;
		for(int i = 0; i < boxes.length; i++) {
			if(boxes[i].canBeAbove(bottom)) {
				ArrayList<Box> newStack = buildTallest(boxes, boxes[i]);
				int newHeight = getHeight(newStack);
				if(newHeight > maxHeight) {
					maxStack = newStack;
					maxHeight = newHeight;
				}
			}
		}
		
		if(maxStack == null) {
			maxStack = new ArrayList<Box>();
		}
		
		if(bottom != null) {
			maxStack.add(bottom);
		}
		
		return maxStack;
	}

	/*
	 * Dynamic programming
	 */
	static ArrayList<Box> buildTallest(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> buffer) throws CloneNotSupportedException {
		if(bottom != null && buffer.containsKey(bottom)) {
			//return buffer.get(bottom);
			ArrayList<Box> bottomStack = buffer.get(bottom);
			ArrayList<Box> cloneStack = new ArrayList<Box>();
			for(Box b : bottomStack) {
				cloneStack.add((Box)b.clone());
			}
			return cloneStack;
		}
		
		int maxHeight = 0;
		ArrayList<Box> maxStack = null;
		for(int i = 0; i < boxes.length; i++) {
			if(boxes[i].canBeAbove(bottom)) {
				ArrayList<Box> newStack = buildTallest(boxes, boxes[i], buffer);
				int newHeight = getHeight(newStack);
				if(newHeight > maxHeight) {
					maxStack = newStack;
					maxHeight = newHeight;
				}
			}
		}
		
		if(maxStack == null) {
			maxStack = new ArrayList<Box>();
		}
		
		if(bottom != null) {
			maxStack.add(bottom);
		}
		buffer.put(bottom, maxStack);
		
		ArrayList<Box> cloneStack = new ArrayList<Box>();
		for(Box b : maxStack) {
			cloneStack.add((Box)b.clone());
		}
		//return (ArrayList<Box>)maxStack.clone();
		return cloneStack;
	}	
	
	static int getHeight(ArrayList<Box> stack) {
		int height = 0;
		for(Box b : stack) {
			height += b.height;
		}
		return height;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		//Box[] boxes = {new Box(1, 2, 3), new Box(2, 4, 9), new Box(5, 2, 7), new Box(3, 1, 7), new Box(9, 1, 5),
		//		new Box(3, 9, 1), new Box(5, 7, 8), new Box(4, 6, 9), new Box(8, 9, 9), new Box(6, 7, 9)};
		Random rd = new Random(System.currentTimeMillis());
		Box[] boxes = new Box[200];
		for(int i = 0; i < 200; i++) {
			boxes[i] = new Box(Math.abs(rd.nextInt()), Math.abs(rd.nextInt()), Math.abs(rd.nextInt()));
		}
		long start = System.currentTimeMillis();
		ArrayList<Box> maxStack = buildTallest(boxes, null);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		for(Box b : maxStack) {
			System.out.println(b + " ");
		}
		
		start = System.currentTimeMillis();
		ArrayList<Box> maxStack2 = buildTallest(boxes, null, new HashMap<Box, ArrayList<Box>>());
		end = System.currentTimeMillis();
		System.out.println(end - start);
		for(Box b : maxStack2) {
			System.out.println(b + " ");
		}
	}
}

class Box implements Cloneable{
	int width;
	int height;
	int depth;
	
	public Box(int w, int h, int d) {
		width = w;
		height = h;
		depth = d;
	}
	
	public boolean canBeAbove(Box b) {
		if(b == null) return true;
		return (this.width < b.width) && (this.height < b.height) && (this.depth < b.depth);
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public String toString() {
		return "Box: width = " + this.width + " height = " + this.height + " depth = " + this.depth;
	}
}