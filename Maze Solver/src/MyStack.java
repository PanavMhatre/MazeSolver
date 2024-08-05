import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack implements StackADT{
	Square[] stack;
	int size;
	int capacity;

	public MyStack() {
		this(4);
	}
	public MyStack(int initCap) {
		stack = new Square[initCap];
		size=0;
		capacity = initCap;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	public Square peek() {
		if(size!=0)
			return stack[size-1];
		throw new EmptyStackException();
	}
	public Square pop() {
		if(size!=0) {
			Square val = stack[size-1];
			size--;
			return val;
		}
		throw new EmptyStackException();
	}
	public void push(Square item) {
		if(stack.length==size) {
			doubleCapacity();
		}
		stack[size]=item;
		size++;
	}
	private void doubleCapacity() {
		Square[] newStackArray = new Square[capacity*2];
		for(int i =0; i<size;i++) {
			newStackArray[i] = stack[i];
		}
		capacity = capacity * 2;
		stack = newStackArray;
		
	}
	
	
	@Override
	public String toString() {
		String toString = "";
		for(int i=0;i<size;i++) {
			toString += stack[i] + "/n";
		}
		return toString;
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public void clear() {
		size=0;
		
	}
	
}
