package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if(isFull()){
			throw new HashtableOverflowException();
		}
		else if (element != null && indexOf(element) == -1) {
			int i = 0;
			boolean inseriu = false;
			while (i < capacity() && !inseriu) {
				int index = ((HashFunctionLinearProbing<T>) getHashFunction()).hash(element, i);
				if (this.table[index] == null || this.deletedElement.equals(this.table[index])) {
					this.table[index] = element;
					this.elements++;
					inseriu = true;
				}
				else {
					i++;
					this.COLLISIONS++;
				}
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null && !isEmpty()) {
			int index = indexOf(element);
			if (index != -1) {
				this.table[index] = new DELETED();
				this.elements--;
			}
		}
	}

	@Override
	public T search(T element) {
		T retorno = null;
		if(element != null) {
			if (indexOf(element) != -1) {
				retorno = element;
			}
		}
		return retorno;
	}

	@Override
	public int indexOf(T element) {
		int retorno = -1;
		if (element != null && !isEmpty()) {
			int i = 0;
			boolean achou = false;
			while (i < capacity() && !achou) {
				int index = ((HashFunctionLinearProbing<T>) getHashFunction()).hash(element, i);
				if (this.table[index] != null || this.deletedElement.equals(this.table[index])) {
					if (this.table[index].equals(element)) {
						retorno = index;
						achou = true;
					} else {
						i++;
					}
				} else i++;
			}
		}
		return retorno;
	}

}
