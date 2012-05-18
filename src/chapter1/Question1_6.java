package chapter1;

/*
 * Given an image represented by an NxN matrix, 
 * where each pixel in the image is 4 bytes, 
 * write a method to rotate the image by 90 degrees
 * Can you do this in place?
 */
public class Question1_6 {
	
	/* in place method */
	public static int[][] rotate(int[][] image) {
		int N = image.length;
		for(int i = 0; i < N / 2; ++i) {
			for(int j = i; j < N - 1 - i; ++j) {
				// save top
				int temp = image[i][j];
				
				// right --> top
				image[i][j] = image[j][N - 1 - i];
				
				// bottom --> right
				image[j][N - 1 - i] = image[N - 1 - i][N - 1 - j];
				
				// left --> bottom
				image[N - 1 - i][N - 1 - j] = image[N - 1 - j][i];
				
				// top --> left
				image[N - 1 - j][i] = temp;
			}
		}

		return image;
	}
	
	public static void print(int[][] im) {
		for(int[] arr : im) {
			for(int i : arr) {
				System.out.print(i + " ");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		int[][] image = {{0, 1, 1, 0, 0},
						 {0, 0, 5, 0, 0},
						 {4, 6, 9, 8, 2},
						 {4, 0, 7, 0, 2},
						 {0, 0, 3, 3, 0},};
		print(image);
		System.out.print("\n");
		print(rotate(image));
	}
}