package chp01_ArraysAndStrings;

import java.util.HashSet;

/*
 * Write an algorithm such that if an element in an M*N matrix is 0, 
 * its entire row and column is set to 0
 */
public class Question1_7 {

	public static void setZero(int[][] matrix) {
		HashSet<Integer> zeroRow = new HashSet<Integer>();
		HashSet<Integer> zeroCol = new HashSet<Integer>();
		for(int i = 0; i < matrix.length; ++i) {
			for(int j = 0; j < matrix[0].length; ++j) {
				if(matrix[i][j] == 0) {
					zeroRow.add(i);
					zeroCol.add(j);
				}
			}
		}
		
		for(int i : zeroRow) {
			for(int j = 0; j < matrix.length; ++j) {
				matrix[i][j] = 0;
			}
		}
		
		for(int j : zeroCol) {
			for(int i = 0; j < matrix[0].length; ++j) {
				matrix[i][j] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{0, 1, 1, 0, 0},
				 		  {0, 0, 5, 0, 0},
				 		  {4, 6, 9, 8, 2},
				 		  {4, 0, 7, 0, 2},
				 		  {0, 0, 3, 3, 0},};
		Question1_6.print(matrix);
		setZero(matrix);
		System.out.print("\n");
		Question1_6.print(matrix);
	}
}