package chapter9;

/*
 * Imagine a robot sitting on the upper left corner of an X by Y grid.
 * The robot can only move in two directions: right and down.
 * How many possible paths are there for the robot to go from (0, 0) to (X, Y)
 * 
 * FOLLOW UP
 * Imagine certain spots are "off limits", such that the robot 
 * cannot step on them. Design an algorithm to find a path for 
 * the robot from the top left to the bottom right 
 */
public class Question9_2 {

	static long countMove(int X, int Y) {
		if(X < 0 || Y < 0) return 0;
		if(X == 0 && Y == 0) return 1;
		if(X > 0 && Y == 0) return countMove(X - 1, Y);
		if(X == 0 && Y > 0) return countMove(X, Y - 1);
		return countMove(X - 1, Y) + countMove(X, Y - 1);
	}
	
	static long[][] cache = new long[100][100];
	static long countMove2(int X, int Y) {
		if(X < 0 || Y < 0) return 0;
		if(X == 0 && Y == 0) return 1;
		if(X == 0 && Y > 0) return countMove2(0, Y - 1);
		if(Y > 0 && X == 0) return countMove2(X - 1, 0);
		if(cache[X][Y] == 0)
			cache[X][Y] = countMove2(X - 1, Y) + countMove2(X, Y - 1);
		return cache[X][Y];
	}
	
	// method fac can easily get overflowed
	static long countMove3(int X, int Y) {
		return fac(X + Y) / (fac(X) * fac(Y));
	}
	
	static long fac(int x) {
		if(x == 1) return 1;
		else {
			return fac(x - 1) * x;
		}
	}
	
	// FOLLOW UP question can be solved by introduce a help function 
	// 'hasPath(int X, int Y) in the if statements in the first countMove function
	
	public static void main(String[] args) {
		System.out.println(countMove3(10, 10));
		System.out.println();
		System.out.println(countMove2(10, 10));
		System.out.println();
		System.out.println(countMove(10, 10));
	}
}
