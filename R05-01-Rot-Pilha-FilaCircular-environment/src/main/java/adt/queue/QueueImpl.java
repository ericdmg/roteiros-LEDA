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
		T retorno = null;
		if (!isEmpty()) {
			return this.array[0];
		}

		return retorno;		}


	@Override
	public boolean isEmpty() {
		boolean retorno = false;
		if(tail == -1){
			retorno = true;
		}
		return retorno;
	}

	@Override
	public boolean isFull() {
		boolean retorno = false;
		if(tail == this.array.length-1){
			retorno = true;
		}
		return retorno;
	}

	private void shiftLeft() {
		for(int i = 0; i <= this.tail; i++){
			this.array[i] = this.array[i + 1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
            throw new QueueOverflowException();
        }
		else if(element != null) {
			this.tail++;
			this.array[tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
	    T retorno = null;
	    if(!isEmpty()){
	        retorno = this.array[0];
	        shiftLeft();
        }
	    else{
	        throw new QueueUnderflowException();
        }

	    return retorno;
    }


}
