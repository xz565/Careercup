package chapter3;

/*
 * Describe how you could use a single array to implement three stacks
 */
public class Question3_1 {

	/* without knowing any additional information about the stack,
	 * fixed capacity is the only way to implement this question */
	int stackSize = 5;
	int[] arr = new int[stackSize * 3];
	int[] stackPointer = {-1, stackSize - 1, stackSize * 2 - 1};
	
	public boolean push(int val, int stackNum) {
		int index = stackPointer[stackNum] + 1;
		if(index - stackSize * stackNum >= stackSize) {
			return false;
		} else {
			stackPointer[stackNum]++;
			arr[index] = val;
			return true;
		}
	}
	
	public int pop(int stackNum) {
		int index = stackPointer[stackNum];
		if(index - stackSize * stackNum >= 0) {
			int value = arr[index];
			stackPointer[stackNum]--;
			arr[index] = 0;
			return value;
		} else {
			return 0;
		}
		
	}
	
	public void print() {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if((i + 1) % stackSize == 0) {
				System.out.print("\n");
			}
		}
		System.out.println(isEmpty(0));
		System.out.println(isEmpty(1));
		System.out.println(isEmpty(2));
		System.out.print("\n");
	}
	
	public boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] - stackNum * stackSize < 0;
	}
	
	public static void main(String[] args) {
		Question3_1 stack = new Question3_1();
		stack.print();
		stack.push(5, 0);
		stack.push(4, 1);
		stack.push(9, 2);
		stack.push(5, 2);
		stack.push(5, 2);
		stack.push(5, 2);
		stack.push(5, 2);
		stack.push(5, 2);
		stack.push(5, 2);
		stack.pop(1);
		stack.print();
	}
	
}