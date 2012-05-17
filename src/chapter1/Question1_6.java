package chapter1;

/*
 * Given an image represented by an NxN matrix, 
 * where each pixel in the image is 4 bytes, 
 * write a method to rotate the image by 90 degrees
 * Can you do this in place?
 */
public class Question1_6 {

	/* first try to use additional buffer 
	 * time: O(N^2) space: O(N^2) */
	public static int[][] rotate(int[][] image) {
		int[][] im = new int[image.length][image[0].length];
		for(int i = 0; i < image.length; i++) {
			for(int j = 0; j < image[0].length; j++) {
				im[j][i] = image[i][j];
			}
		}
		return im;
	}
	
	/* in place method 
	 * time: O((N^2)/2) space O(1)*/
	public static int[][] rotate2(int[][] image) {
		for(int i = 0; i < image.length; i++) {
			for(int j = i; j < image[0].length; j++) {
				// exchange ij and ji
				int tmp = image[i][j];	
				image[i][j] = image[j][i];
				image[j][i] = tmp;
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
		int[][] image = {{0, 0, 1, 0, 0},
				         {0, 1, 1, 1, 0},
				         {1, 1, 0, 1, 1},
				         {1, 1, 0, 1, 1},
				         {1, 1, 0, 1, 1}};
		print(image);
		System.out.print("\n");
		print(rotate(image));
		System.out.print("\n");
		print(rotate2(image));
	}
}