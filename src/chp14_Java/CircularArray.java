package chp14_Java;

import java.util.Iterator;

/*
 * Implement a CircularArray class that supports an array-like data structure
 * which can be efficient rotated. The class should use a generic type, and
 * should support iteration via the standard for (Obj o : circularArray) notationw
 */
public class CircularArray<T> implements Iterable<T>{
	
	private T[]  items;
	private int head = 0;
	
	@SuppressWarnings("unchecked")
	public CircularArray(int size) {
		items = (T[]) new Object[size];
	}
	
	private int convert(int index) {
		if(index < 0) {
			index += items.length;
		}
		return (head + index) % items.length;
	}
	
	public void rotate(int shiftRight) {
		head = convert(shiftRight);
	}
	
	public T get(int i) {
		if(i < 0 || i >= items.length) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		return items[convert(i)];
	}
	
	public void set(int i, T item) {
		items[convert(i)] = item;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator<T>(this);
	}
	
	public static void main(String[] args) {
		CircularArray<String> cArray = new CircularArray<String>(10);
		cArray.set(0, "Hello World");
		cArray.set(3, "Hello Again");
		//System.out.println(cArray.get(0));
		for(String s : cArray)
			System.out.println(s);
	}


	private class CircularArrayIterator<TI> implements Iterator<TI> {
	
		private int _current = -1;
		private TI[] _items;
		
		public CircularArrayIterator(CircularArray<TI> array) {
			_items = array.items;
		}
		
		@Override
		public boolean hasNext() {
			return _current < items.length - 1;
		}
	
		@Override
		public TI next() {
			_current++;
			TI item = (TI) _items[convert(_current)];
			return item;
		}
	
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}