package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T retorno = null;
		if (isEmpty()) {
			retorno = null;
		}

		else {
			this.top--;
			retorno =  this.array[top + 1];
		}
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		if (this.top == -1){
			return true;
		}
		else return false;
	}

	@Override
	public boolean isFull() {
		if (this.top == this.array.length){
			return true;
		}
		else return false;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(this.top == this.array.length - 1){
			throw new StackOverflowException();
		}
		this.top++;
		this.array[top] = element;

	}

	@Override
	public T pop() throws StackUnderflowException {
		T retorno = null;
		if (isEmpty()) {
			throw new StackUnderflowException();
		}

		else {
			this.top--;
			retorno =  this.array[top + 1];
		}
		return retorno;
	}

}
