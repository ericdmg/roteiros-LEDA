package adt.bst;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
		if (!getRoot().isEmpty()){
			height = getHeight(((BSTNode<T>)getRoot()));
		}
		return height;
	}

	private int getHeight(BSTNode<T> node) {
		int answer;
		if(node.isEmpty()){
			answer = 0;
		}
		int leftHeight = getHeight(((BSTNode<T>)getRoot().getLeft()));
		int rightHeight = getHeight(((BSTNode<T>)getRoot().getRight()));
		answer = 1 + Math.max(leftHeight,rightHeight);
		return answer;
	}

	@Override
	public BSTNode<T> search(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void insert(T element) {
		treeInsert(getRoot(),new BSTNode<>(),element);
	}

	private void treeInsert(BSTNode<T> node, BSTNode<T> parent, T element) {
		if(node.isEmpty()){
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.setRight(new BSTNode<>());
			node.setParent(parent);

		}
		else if(node.getData().compareTo(element) < 0){
			treeInsert(((BSTNode<T>) node.getRight()),node,element);
		}
		else if(node.getData().compareTo(element) > 0){
			treeInsert(((BSTNode<T>) node.getLeft()),node,element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> minimum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		T[] arrayPreOrder = (T[]) new Comparable[size()];
		ArrayList<T> arrayListPreOrder = new ArrayList<>();
		preOrdering(getRoot(),arrayListPreOrder);
		for (int i = 0; i < arrayPreOrder.length; i++) {
			arrayPreOrder[i] = arrayListPreOrder.get(i);
		}
		return arrayPreOrder;
	}

	private void preOrdering(BSTNode<T> node, ArrayList<T> arrayListPostOrder) {
		if(!node.isEmpty()) {
			arrayListPostOrder.add(node.getData());
			preOrdering(((BSTNode<T>)node.getLeft()),arrayListPostOrder);
			preOrdering(((BSTNode<T>)node.getRight()),arrayListPostOrder);
		}
	}

	@Override
	public T[] order() {
		T[] arrayOrder = (T[]) new Comparable[size()];
		ArrayList<T> arrayListOrder = new ArrayList<>();
		ordering(getRoot(),arrayListOrder);
		for (int i = 0; i < arrayOrder.length; i++) {
			arrayOrder[i] = arrayListOrder.get(i);
		}
		return arrayOrder;
	}

	private void ordering(BSTNode<T> node, ArrayList<T> arrayListOrder) {
		if(!node.isEmpty()){
			ordering(((BSTNode<T>) node.getLeft()),arrayListOrder);
			arrayListOrder.add(node.getData());
			ordering(((BSTNode<T>) node.getRight()),arrayListOrder);
		}
	}


	@Override
	public T[] postOrder() {
		T[] arrayPostOrder = (T[]) new Comparable[size()];
		ArrayList<T> arrayListPostOrder = new ArrayList<>();
		postOrdering(getRoot(),arrayListPostOrder);
		for (int i = 0; i < arrayPostOrder.length; i++) {
			arrayPostOrder[i] = arrayListPostOrder.get(i);
		}
		return arrayPostOrder;
	}

	private void postOrdering(BSTNode<T> node, ArrayList<T> arrayListPostOrder) {
		if(!node.isEmpty()){
			postOrdering(((BSTNode<T>) node.getLeft()),arrayListPostOrder);
			postOrdering(((BSTNode<T>) node.getRight()),arrayListPostOrder);
			arrayListPostOrder.add(node.getData());
		}
	}



	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
