package chapter11;

import java.util.Random;

public class SortingAlgorithms {

	static void mergeSort(int[] array, int start, int end) {
		if(start < end) {
			int middle = (start + end) / 2;
			mergeSort(array, start, middle);
			mergeSort(array, middle + 1, end);
			merge(array, start, middle, end);
		}
	}
	
	static void merge(int[] array, int low, int middle, int high) {
		int[] buffer = new int[array.length];
		
		for(int i = low; i <= high; i++) {
			buffer[i] = array[i];
		}
		
		int bufferLeft = low;
		int bufferRight = middle + 1;
		int currt = low;
		
		while(bufferLeft <= middle && bufferRight <= high) {
			if(buffer[bufferLeft] <= buffer[bufferRight]) {
				array[currt] = buffer[bufferLeft];
				bufferLeft++;
			} else {
				array[currt] = buffer[bufferRight];
				bufferRight++;
			}
			currt++;
		}
		
		int remaining = middle - bufferLeft;
		for(int i = 0; i <= remaining; i++) {
			array[currt + i] = buffer[bufferLeft + i]; 
		}
	}
	
	static void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}
	
	static void quickSort(int[] array, int left, int right) {
		int index = partition(array, left, right);
		if(left < index - 1)
			quickSort(array, left, index - 1);
		if(index < right)
			quickSort(array, index, right);
	}
	
	static int partition(int[] array, int left, int right) {
		int pivot = array[(left + right) / 2];
		while(left < right) {
			while(array[left] < pivot) left++;
			while(pivot < array[right]) right--;
			if(left <= right) {
				//swap(array, left, right);
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static void main(String[] args) throws InterruptedException {
		int[] array = new int[99999999];
		Random rd = new Random(System.currentTimeMillis());
		for(int i = 0; i < array.length; i++) {
			array[i] = new Integer(rd.nextInt());
		}
		
		
		int[] array2 = array.clone();
		long start = System.currentTimeMillis(); 
		quickSort(array2, 0, array2.length - 1);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		//Thread.sleep(2000);
		
		//int[] array3 = array.clone();
		//print(array3);
		
		//Thread.sleep(2000);
		
		start = System.currentTimeMillis(); 
		//mergeSort(array3, 0, array3.length - 1);
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		//Thread.sleep(2000);
		
		//print(array3);
	}
}
