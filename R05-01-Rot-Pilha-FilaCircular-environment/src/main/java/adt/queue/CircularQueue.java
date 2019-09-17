package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
        if(isFull()){
            throw new QueueOverflowException();
        }
        else if(element != null){
            if (this.head == -1 && this.tail == -1){
                this.head = 0;
            }
            if(this.head != 0 && this.tail == this.array.length-1){
                this.tail = 0;

            }
            else this.tail++;
            this.array[this.tail] = element;
            this.elements++;
        }
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
		    throw new QueueUnderflowException();
        }

        T retorno = this.array[this.head];
		this.head++;
		elements--;
        if(head == this.array.length){
            head = 0;
        }
		return retorno;

	}

	@Override
	public T head() {
        T retorno = null;
        if (!isEmpty()) {
            return this.array[head];
        }

        return retorno;
    }

	@Override
	public boolean isEmpty() {
        boolean retorno = false;
        if(this.elements == 0){
            retorno = true;
        }

        return retorno;
	}

	@Override
	public boolean isFull() {
	    boolean retorno = false;
        if(elements == this.array.length){
            retorno = true;
        }

        return retorno;
	}

}
