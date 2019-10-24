package adt.bst.extended;

import java.util.ArrayList;
import java.util.Comparator;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em suas funcionalidades
 * e possui um metodo de ordenar um array dado como parametro, retornando o resultado do percurso
 * desejado que produz o array ordenado. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

	private Comparator<T> comparator;
	
	public SortComparatorBSTImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	@Override
	public T[] sort(T[] array) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}


	

	@Override
	public T[] reverseOrder() {
		ArrayList<T> arrayListReverseOrder = new ArrayList<>();
		reverseOrdering(getRoot(), arrayListReverseOrder);
		return (T[]) arrayListReverseOrder.toArray(new Comparable[size()]);
	}

	private void reverseOrdering(BSTNode<T> node, ArrayList<T> arrayListReverseOrder) {
		if (!node.isEmpty()) {
			reverseOrdering(((BSTNode<T>) node.getRight()), arrayListReverseOrder);
			arrayListReverseOrder.add(node.getData());
			reverseOrdering(((BSTNode<T>) node.getLeft()), arrayListReverseOrder);

		}
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
}
