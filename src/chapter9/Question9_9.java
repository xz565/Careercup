package chapter9;

import java.util.ArrayList;

/*
 * Write an algorithm to print all ways of arranging eight queens
 * on an 8*8 chess board so that none of them share the same row,
 * column or diagonal.
 * 
 * In this case, "diagonal" means all diagonals, not just the two 
 * that bisect the board.
 */
public class Question9_9 {

	static final int GRID_SIZE = 14;
	
	static void putQueens(int row, Integer[] board, ArrayList<Integer[]> results) {
		if(row == GRID_SIZE) {
			results.add(board.clone());
		}
		
		for(int column = 0; column < GRID_SIZE; column++) {
			if(checkBoard(row, column, board)) {
				board[row] = column;
				putQueens(row + 1, board, results);
			}
		}
	}
	
	static boolean checkBoard(int row, int column, Integer[] board) {
		for(int newRow = 0; newRow < row; newRow++) {
			int newColumn = board[newRow];
			
			if(column == newColumn) 
				return false;
			
			int rowDist = row - newRow;
			int colDist = Math.abs(column - newColumn);
			if(rowDist == colDist)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		Integer[] board = new Integer[GRID_SIZE];
		putQueens(0, board, results);
		System.out.print(results.size());
	}
}
