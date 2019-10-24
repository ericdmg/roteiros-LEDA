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
		this.root = new BSTNode<T>();
		for (T elemment : array) {
			insert(elemment);
		}

		return order();
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> searchedNode = new BSTNode<>();
		if (!getRoot().isEmpty() && element != null) {
			searchedNode = recursiveSearch(getRoot(), element);
		}
		return searchedNode;
	}

	private BSTNode<T> recursiveSearch(BSTNode<T> node, T element) {
		BSTNode<T> searchedNode = new BSTNode<>();
		if (!node.isEmpty()) {
			if (getComparator().compare(node.getData(),element) == 0) {
				searchedNode = node;
			} else if (getComparator().compare(node.getData(),element) < 0) {
				searchedNode = recursiveSearch(((BSTNode<T>) node.getRight()), element);
			} else if (getComparator().compare(node.getData(),element) > 0) {
				searchedNode = recursiveSearch(((BSTNode<T>) node.getLeft()), element);
			}
		}
		return searchedNode;
	}



	@Override
	public T[] reverseOrder() {
		ArrayList<T> arrayListReverseOrder = new ArrayList<>();
		reverseOrdering(getRoot(), arrayListReverseOrder);
		return (T[]) arrayListReverseOrder.toArray(new Comparable[size()]);
	}

	@Override
	public void insert(T element) {
		if(element != null && search(element).isEmpty()) {
			treeInsert(getRoot(), new BSTNode<>(), element);
		}
	}

	private void treeInsert(BSTNode<T> node, BSTNode<T> parent, T element) {

		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.setRight(new BSTNode<>());
			node.setParent(parent);

		} else if (getComparator().compare(node.getData(),element) < 0) {
			treeInsert(((BSTNode<T>) node.getRight()), node, element);
		} else if (getComparator().compare(node.getData(),element) > 0) {
			treeInsert(((BSTNode<T>) node.getLeft()), node, element);
		}
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
