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
		T retorno;
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
	    boolean retorno = false;
		if (this.top == -1){
			retorno = true;
		}
		return retorno;
	}

	@Override
	public boolean isFull() {
	    boolean retorno = false;
		if (this.top == this.array.length){
			retorno = true;
		}
        return retorno;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (this.top == this.array.length - 1) {
			throw new StackOverflowException();
		} else if (element != null) {
			this.top++;
			this.array[top] = element;

		}
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
