package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if (element != null) {
			inserir(element, new RecursiveDoubleLinkedListImpl<T>());
		}

	}

	private void inserir(T element, RecursiveDoubleLinkedListImpl<T> previous) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<>());
				setPrevious(previous);

			}
			else ((RecursiveDoubleLinkedListImpl<T>)  getNext()).inserir(element,this);

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

	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			if(size() == 1){
				setData(getNext().getData());
				setNext(new RecursiveDoubleLinkedListImpl<T>());
				setPrevious(new RecursiveDoubleLinkedListImpl<T>());

			}
			else{
				RecursiveDoubleLinkedListImpl<T> next = (RecursiveDoubleLinkedListImpl<T>) getNext().getNext();
				setData(getNext().getData());
				setNext(next);
				next.setPrevious(this);
			}
		}
	}

	@Override
	public void removeLast() {

		if(getNext().isEmpty()) {
			if (size() == 1){
				setData(null);
			}

			else {
				getPrevious().setNext(new RecursiveDoubleLinkedListImpl<>());
				setPrevious(null);
			}

		}

		else ((RecursiveDoubleLinkedListImpl<T>)  getNext()).removeLast();
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()){
			if (getData().equals(element)){
				setData(getNext().getData());
				setNext(getNext().getNext());
				if(getNext() != null){
					((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
				}

			}
			else getNext().remove(element);
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
