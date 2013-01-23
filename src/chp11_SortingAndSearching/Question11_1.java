package chp11_SortingAndSearching;

/*
 * You are given two sorted arrays, A and B, where A has a large enough
 * buffer at the end to hold B.
 * 
 * Write a method to merge B into a in sorted order
 */
public class Question11_1 {

	static void merge(int[] A, int[] B, int lastA, int lastB) {
		int last = lastA + lastB + 1;
		while(lastA >= 0 && lastB >= 0) {
			if(A[lastA] >= B[lastB]) {
				A[last] = A[lastA];
				lastA--;
			} else {
				A[last] = B[lastB];
				lastB--;
			}
			last--;
		}
		
		int remaining = lastB - 0;
		for(int i = 0; i < remaining; i++) {
			A[last - i] = B[lastB - i];
		}
	}
	
	public static void main(String[] args) {
		int[] A = new int[30];
		int[] B = new int[20];
		for(int i = 0; i < 10; i++) {
			A[i] = i + 3 * i;
			B[i] = i + 2 * i;
		}
		SortingAlgorithms.print(A);
		SortingAlgorithms.print(B);
		merge(A, B, 9, 9);
		SortingAlgorithms.print(A);
	}
}
