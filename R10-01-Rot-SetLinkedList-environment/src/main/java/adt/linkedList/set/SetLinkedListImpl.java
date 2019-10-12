package adt.linkedList.set;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> {

	@Override
	public void removeDuplicates() {
		SingleLinkedListNode aux = getHead();
		while(!aux.isNIL()){
			SingleLinkedListNode prev = aux;
			SingleLinkedListNode next = aux.getNext();
			while(!next.isNIL()){
				if(aux.equals(next)){
					prev.setNext(next.getNext());
					next = next.getNext();
				}
				else{
					prev = next;
					next = next.getNext();
				}
			}
			aux = aux.getNext();
		}

	}

	@Override
	public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
		SetLinkedList<T> listaUniao = new SetLinkedListImpl<T>();
        if(otherSet != null) {
            SingleLinkedListNode<T> aux = getHead();
            while (!aux.isNIL()) {
                listaUniao.insert(aux.getData());
                aux = aux.getNext();
            }

            T[] outraLista = otherSet.toArray();
            for (T elemento : outraLista) {
                listaUniao.insert(elemento);
            }
        }
        listaUniao.removeDuplicates();
        return listaUniao;
	}

	@Override
	public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
		SetLinkedList<T> listaInterseccao = new SetLinkedListImpl<T>();
        if(otherSet != null) {
            T[] copiaLista1 = toArray();
            T[] copiaLista2 = otherSet.toArray();
            for (T elementList1 : copiaLista1) {
                for (T elementList2 : copiaLista2) {
                    if (elementList1.equals(elementList2)) {
                        listaInterseccao.insert(elementList1);
                    }
                }
            }
        }
        listaInterseccao.removeDuplicates();
        return listaInterseccao;
	}

	@Override
	public void concatenate(SetLinkedList<T> otherSet) {
        if (otherSet != null) {
            T[] array = otherSet.toArray();
            for (T element : array) {
                insert(element);
            }
        }
        removeDuplicates();
    }

}
