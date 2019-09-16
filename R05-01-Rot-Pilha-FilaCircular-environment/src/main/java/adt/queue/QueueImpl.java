package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
			return this.array[0];
		}


	@Override
	public boolean isEmpty() {
		if(tail == -1){
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(tail == this.array.length){
			return true;
		}
		return false;
	}

	private void shiftLeft() {
		for(int i = 0; i <= this.tail; i++){
			this.array[i] = this.array[i + 1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
