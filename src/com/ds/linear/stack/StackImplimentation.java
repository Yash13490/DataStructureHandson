package com.ds.linear.stack;

public class StackImplimentation {

	// Used array defualt capacity
	protected int capacity;
	protected int stackRep[];
	protected int top = -1;
	public final static int CAPACITY = 10;

	public StackImplimentation() {
		this(CAPACITY);
	}

	public StackImplimentation(int cap) {
		capacity = cap;
		stackRep = new int[capacity];
	}

	public int stackSize() {
		return top +1;
	}

	public boolean isEmpty() {
		if(top == -1)
			return true;
		else 
			return false;
	}

	public void push(int data) throws Exception {
		if(stackSize()==capacity) 
			throw new Exception("Stack is full");
		stackRep[++top] = data;

	}

	public int top() throws Exception {
		if(isEmpty())
			throw new Exception("Stack is Empty");
		else 
			return stackRep[++top];
	}

	public int pop() throws Exception {
		int data;
		if(isEmpty())
			throw new Exception("Stack is empty");
		else
			data = stackRep[top];
		top--;
		return data;

	}

}
