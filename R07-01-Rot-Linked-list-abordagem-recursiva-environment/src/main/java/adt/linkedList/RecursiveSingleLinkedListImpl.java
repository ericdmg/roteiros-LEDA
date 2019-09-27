package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return getData() == null;
	}

	@Override
	public int size() {
		int retorno;
		if(isEmpty()){
			retorno = 0;
		}
		else retorno = 1 + getNext().size();
		return retorno;
	}

	@Override
	public T search(T element) {
		T elementoProcurado = null;
		if(element != null && !isEmpty()) {
				if (getData().equals(element)){
					elementoProcurado = getData();
				}
				else{
					elementoProcurado = getNext().search(element);
				}
			}
		return elementoProcurado;
	}


	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveSingleLinkedListImpl<>());
			} else getNext().insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()){
			if (getData().equals(element)){
				setData(getNext().getData());
				setNext(getNext().getNext());
			}
			else getNext().remove(element);
		}
	}

	@Override
	public T[] toArray() {
		T[] listaEmArray =  (T[]) new Object[size()];
		if(!isEmpty()){
			int contador = 0;
			listaEmArray[contador] = getData();
			contador++;
			converteParaArray(listaEmArray, getNext(),contador);
		}

		return listaEmArray;
	}

	private void converteParaArray(T[] listaEmArray, RecursiveSingleLinkedListImpl<T> next, int contador) {
		if(contador < size() && !isEmpty()){
			listaEmArray[contador] = next.getData();
			contador++;
			converteParaArray(listaEmArray,next.getNext(),contador);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
