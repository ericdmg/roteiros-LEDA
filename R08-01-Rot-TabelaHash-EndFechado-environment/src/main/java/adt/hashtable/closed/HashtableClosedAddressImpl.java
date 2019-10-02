package adt.hashtable.closed;

import adt.hashtable.hashfunction.*;
import util.Util;

import java.util.LinkedList;

public class HashtableClosedAddressImpl<T> extends
		AbstractHashtableClosedAddress<T> {

	/**
	 * A hash table with closed address works with a hash function with closed
	 * address. Such a function can follow one of these methods: DIVISION or
	 * MULTIPLICATION. In the DIVISION method, it is useful to change the size
	 * of the table to an integer that is prime. This can be achieved by
	 * producing such a prime number that is bigger and close to the desired
	 * size.
	 * <p>
	 * For doing that, you have auxiliary methods: Util.isPrime and
	 * getPrimeAbove as documented bellow.
	 * <p>
	 * The length of the internal table must be the immediate prime number
	 * greater than the given size (or the given size, if it is already prime).
	 * For example, if size=10 then the length must
	 * be 11. If size=20, the length must be 23. You must implement this idea in
	 * the auxiliary method getPrimeAbove(int size) and use it.
	 *
	 * @param desiredSize
	 * @param method
	 */

	@SuppressWarnings({"rawtypes", "unchecked"})
	public HashtableClosedAddressImpl(int desiredSize,
									  HashFunctionClosedAddressMethod method) {
		int realSize = desiredSize;

		if (method == HashFunctionClosedAddressMethod.DIVISION) {
			realSize = this.getPrimeAbove(desiredSize); // real size must the
			// the immediate prime
			// above
		}
		initiateInternalTable(realSize);
		HashFunction function = HashFunctionFactory.createHashFunction(method,
				realSize);
		this.hashFunction = function;
	}

	// AUXILIARY

	/**
	 * It returns the prime number that is closest (and greater) to the given
	 * number.
	 * If the given number is prime, it is returned.
	 * You can use the method Util.isPrime to check if a number is
	 * prime.
	 */
	int getPrimeAbove(int number) {
			int retorno;
			if (Util.isPrime(number)) {
				retorno = number;
			} else retorno = getPrimeAbove(number + 1);
			return retorno;
		}


	@Override
	public void insert(T element) {
		if (element != null) {
			int index = ((HashFunctionClosedAddress<T>) this.hashFunction).hash(element);
			LinkedList<T> lista = ((LinkedList<T>) this.table[index]);
			if (lista == null) {
				lista = new LinkedList<T>();
				lista.add(element);
				this.elements++;
			} else {
				if (lista.size() > 0) {
					this.COLLISIONS++;
				}
				lista.add(element);
				this.elements++;
			}
			this.table[index] = lista;
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()) {
			int index = indexOf(element);
			if(index != -1){
				((LinkedList<T>) this.table[index]).remove(element);
				this.elements--;
			}
			}
		}


	@Override
	public T search(T element) {
		T retorno = null;
		if(indexOf(element) != -1){
			retorno = element;
		}
		return retorno;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;
		if (element != null && !isEmpty()) {
			int hash = ((HashFunctionClosedAddress<T>) this.hashFunction).hash(element);
			LinkedList<T> lista = ((LinkedList<T>) this.table[hash]);
			boolean achou = false;
			if (lista != null) {
				int i = 0;
				while (!achou && i < lista.size()) {
					if (lista.get(i).equals(element)) {
						achou = true;
						index = hash;
					}
					i++;
				}
			}
		}
		return index;
	}
}
