package chp11_SortingAndSearching;

/*
 * Given a matrix in which each row and each column is sorted, 
 * write a method to find an element in it.
 */
public class Question11_6 {

	static boolean searchM(int[][] matrix, int num) {
		int row = 0;
		int column = matrix[0].length - 1;
		
		while(row < matrix.length && column >= 0) {
			if(matrix[row][column] == num)
				return true;
			else if(matrix[row][column] > num) {
				column--;
			} else {
				row++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{15, 20, 40,  85}, 
				{20, 35, 80, 95}, 
				{30, 55, 95, 105},
				{40, 80, 100, 120}};
		
		System.out.println(searchM(matrix, 100));
		System.out.println(searchM(matrix, 60));
	}
}
