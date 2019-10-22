package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
        int size = 0;
        SingleLinkedListNode aux = this.head;
        while(!aux.isNIL()){
            size++;
            aux = aux.next;
        }
        return size;
	}

	@Override
	public T search(T element) {
	    SingleLinkedListNode aux = this.head;
	    T key = null;
	    if(element != null) {
			while (!aux.isNIL() && !element.equals(key)) {
				aux = aux.next;
				key = (T) aux.data;
			}
		}
	    return key;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			SingleLinkedListNode auxHead = this.head;
			if (this.head.isNIL()) {
				SingleLinkedListNode newHead = new SingleLinkedListNode(element, this.head);
				this.head = newHead;
			} else {
				while (!auxHead.next.isNIL()) {
					auxHead = auxHead.next;
				}
				SingleLinkedListNode newNode = new SingleLinkedListNode(element, auxHead.next);
				auxHead.next = newNode;
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null){
			if (this.head.data.equals(element)) {
				this.head = this.head.next;
			} else {
				SingleLinkedListNode aux = this.head;
				SingleLinkedListNode previous = aux;
				while (!aux.isNIL() && !aux.data.equals(element)) {
					previous = aux;
					aux = aux.next;
				}
				if (!aux.isNIL()) {
					previous.next = aux.next;
				}
			}
		}
    }

	@Override
	public T[] toArray() {
	    T[] result =  (T[]) new Comparable[size()];
	    SingleLinkedListNode aux = head;
	    int count = 0;
	    while(!aux.isNIL()){
	        result[count] = (T) aux.data;
	        aux = aux.next;
	        count++;
        }
	    return result;
    }

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

	public void reverseAppend(T element){
		SingleLinkedListNode<T> prev = new SingleLinkedListNode<>();
		SingleLinkedListNode<T> current = getHead();
		SingleLinkedListNode<T> next = current.getNext();
		while(!current.isNIL()){
			current.setNext(prev);
			prev = current;
			current = next;
			next = current.getNext();
		}

		current.setData(element);
		current.setNext(prev);

		this.head = current;
	}

}
