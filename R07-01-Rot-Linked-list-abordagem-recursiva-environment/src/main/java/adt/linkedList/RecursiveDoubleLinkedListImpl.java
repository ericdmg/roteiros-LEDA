package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element){
		if (element != null && isEmpty()) {
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<>());
				if(getPrevious() == null){
					setPrevious(new RecursiveDoubleLinkedListImpl<>());

			}
		}
		else getNext().insert(element);
	}
	@Override
	public void insertFirst(T element) {
		if(element != null) {
			T aux = getData();
			setData(element);
			RecursiveDoubleLinkedListImpl<T> node = new RecursiveDoubleLinkedListImpl<T>();
			node.setData(aux);
			node.setNext(getNext());
			node.setPrevious(this);
			setNext(node);
		}

		/**
		 * A lógica então fica tipo:
		 * V value = this.value
		 * this.value = valor novo
		 * Node n = new Node
		 * n.value = value
		 * n.next = this.next
		 * n.previous = this
		 * this.next = n
		 */
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			RecursiveDoubleLinkedListImpl<T> next =(RecursiveDoubleLinkedListImpl<T>) getNext().getNext();
			setData(getNext().getData());
			setNext(next);
		}
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
