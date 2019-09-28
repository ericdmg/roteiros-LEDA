package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(element != null){
			if(isFull()){
				throw new StackOverflowException();
			}
			else this.top.insert(element);
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
		return this.top.size() == 0;
	}

	@Override
	public boolean isFull() {
		return this.top.size() == this.size;

	}

}
