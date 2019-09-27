package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		} else if (element != null) {
			this.top.insert(element);
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()){
			throw new StackUnderflowException();
		}
		T top = top();
		this.top.removeLast();
		return top;
	}

	@Override
	public T top() {
		T retorno = null;
		if(!isEmpty()){
			int indiceTop = this.top.toArray().length - 1;
			retorno = this.top.toArray()[indiceTop];
		}
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		boolean retorno = false;
		if(this.top.size() == 0){
			retorno = true;
		}
		return retorno;
	}

	@Override
	public boolean isFull() {
		boolean retorno = false;
		if(this.top.size() == this.size){
			retorno = true;
		}
		return retorno;
	}

}
