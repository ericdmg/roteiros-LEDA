package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		int height = -1;
		if (!getRoot().isEmpty()) {
			height = getHeight(getRoot());
		}
		return height;
	}

	protected int getHeight(BSTNode<T> node) {
		int answer;
		if (node.isEmpty()) {
			answer = -1;
		}

		else {
			int leftHeight = getHeight(((BSTNode<T>) node.getLeft()));
			int rightHeight = getHeight(((BSTNode<T>) node.getRight()));
			answer = 1 + Math.max(leftHeight, rightHeight);
		}
		return answer;
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
			if (node.getData().compareTo(element) == 0) {
				searchedNode = node;
			} else if (node.getData().compareTo(element) < 0) {
				searchedNode = recursiveSearch(((BSTNode<T>) node.getRight()), element);
			} else if (node.getData().compareTo(element) > 0) {
				searchedNode = recursiveSearch(((BSTNode<T>) node.getLeft()), element);
			}
		}
		return searchedNode;
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

		} else if (node.getData().compareTo(element) < 0) {
			treeInsert(((BSTNode<T>) node.getRight()), node, element);
		} else if (node.getData().compareTo(element) > 0) {
			treeInsert(((BSTNode<T>) node.getLeft()), node, element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> maximumNode = null;
		if (!getRoot().isEmpty()) {
			maximumNode = recursiveMaximum(getRoot());
		}
		return maximumNode;
	}

	private BSTNode<T> recursiveMaximum(BSTNode<T> node) {
		BSTNode<T> maximumNode = null;
		if (node.isLeaf() || node.getRight().isEmpty()) {
			maximumNode = node;
		} else
			maximumNode = recursiveMaximum(((BSTNode<T>) node.getRight()));
		return maximumNode;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> minimumNode = null;
		if (!getRoot().isEmpty()) {
			minimumNode = recursiveMinimum(getRoot());
		}
		return minimumNode;
	}

	private BSTNode<T> recursiveMinimum(BSTNode<T> node) {
		BSTNode<T> minimumNode = null;
		if (node.isLeaf() || node.getLeft().isEmpty()) {
			minimumNode = node;
		} else
			minimumNode = recursiveMinimum(((BSTNode<T>) node.getLeft()));
		return minimumNode;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> sucessor = null;
		if (!getRoot().isEmpty() && element != null && !search(element).isEmpty()) {
			BSTNode<T> node = search(element);
			if (!node.getRight().isEmpty()) {
				sucessor = recursiveMinimum(((BSTNode<T>) node.getRight()));
			} else {
				BSTNode<T> aux = ((BSTNode<T>) node.getParent());
				while (!aux.isEmpty() && aux.getRight().equals(node)) {
					node = aux;
					aux = ((BSTNode<T>) aux.getParent());
				}
				sucessor = aux;
			}
			if (sucessor.isEmpty()) {
				sucessor = null;
			}
		}

		return sucessor;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> predecessor = null;
		if (!getRoot().isEmpty() && element != null && !search(element).isEmpty()) {
			BSTNode<T> node = search(element);
			if (!node.getLeft().isEmpty()) {
				predecessor = recursiveMaximum(((BSTNode<T>) node.getLeft()));
			} else {
				BSTNode<T> aux = ((BSTNode<T>) node.getParent());
				while (!aux.isEmpty() && aux.getLeft().equals(node)) {
					node = aux;
					aux = ((BSTNode<T>) aux.getParent());
				}
				predecessor = aux;
			}
			if (predecessor.isEmpty()) {
				predecessor = null;
			}
		}
		return predecessor;
	}

	@Override
	public void remove(T element) {
		if (!getRoot().isEmpty() && element != null && !search(element).isEmpty()) {
			removal(element);
		}
	}

	private void removal(T element) {
		BSTNode<T> aux = search(element);
		if (aux.isLeaf()) {
			aux.setData(null);
		} else if ((aux.getLeft().isEmpty() && !aux.getRight().isEmpty())) {
			aux.setData(aux.getRight().getData());
			aux.setLeft(aux.getRight().getLeft());
			aux.setRight(aux.getRight().getRight());
		} else if ((aux.getRight().isEmpty() && !aux.getLeft().isEmpty())) {
			aux.setData(aux.getLeft().getData());
			aux.setRight(aux.getLeft().getRight());
			aux.setLeft(aux.getLeft().getLeft());
		} else {
			T sucessor = sucessor(element).getData();
			removal(sucessor);
			aux.setData(sucessor);
		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> arrayListPreOrder = new ArrayList<>();
		preOrdering(getRoot(), arrayListPreOrder);
		return (T[]) arrayListPreOrder.toArray(new Comparable[size()]);
	}

	private void preOrdering(BSTNode<T> node, ArrayList<T> arrayListPreOrder) {
		if (!node.isEmpty()) {
			arrayListPreOrder.add(node.getData());
			preOrdering(((BSTNode<T>) node.getLeft()), arrayListPreOrder);
			preOrdering(((BSTNode<T>) node.getRight()), arrayListPreOrder);
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> arrayListOrder = new ArrayList<>();
		ordering(getRoot(), arrayListOrder);
		return (T[]) arrayListOrder.toArray(new Comparable[size()]);
	}

	private void ordering(BSTNode<T> node, ArrayList<T> arrayListOrder) {
		if (!node.isEmpty()) {
			ordering(((BSTNode<T>) node.getLeft()), arrayListOrder);
			arrayListOrder.add(node.getData());
			ordering(((BSTNode<T>) node.getRight()), arrayListOrder);
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> arrayListPostOrder = new ArrayList<>();
		postOrdering(getRoot(), arrayListPostOrder);
		return (T[]) arrayListPostOrder.toArray(new Comparable[size()]);
	}

	private void postOrdering(BSTNode<T> node, ArrayList<T> arrayListPostOrder) {
		if (!node.isEmpty()) {
			postOrdering(((BSTNode<T>) node.getLeft()), arrayListPostOrder);
			postOrdering(((BSTNode<T>) node.getRight()), arrayListPostOrder);
			arrayListPostOrder.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it works and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
