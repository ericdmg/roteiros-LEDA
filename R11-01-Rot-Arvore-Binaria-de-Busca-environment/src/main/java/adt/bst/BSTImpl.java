package adt.bst;

import adt.bt.BTNode;

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

   private int getHeight(BSTNode<T> node) {
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
            sucessor = recursiveSucessor(aux,node);
         }
         if (sucessor.isEmpty()) {
            sucessor = null;
         }
      }

      return sucessor;
   }

   public BSTNode<T> recursiveSucessor(BSTNode<T> aux, BSTNode<T> previousAux){
      BSTNode<T> sucessor;
      if(aux.isEmpty()){
         sucessor = null;
      }
      else if(aux.getData().compareTo(previousAux.getData()) < 0){
         sucessor = previousAux;
      }
      else sucessor = recursiveSucessor(((BSTNode<T>) aux.getParent()),((BSTNode<T>) previousAux.getParent()));
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

   public T[] reverseOrder() {
      ArrayList<T> arrayListOrder = new ArrayList<>();
      reverseOrdering(getRoot(), arrayListOrder);
      return (T[]) arrayListOrder.toArray(new Comparable[size()]);
   }

   private void reverseOrdering(BSTNode<T> node, ArrayList<T> arrayListOrder) {
      if (!node.isEmpty()) {
         reverseOrdering(((BSTNode<T>) node.getRight()), arrayListOrder);
         arrayListOrder.add(node.getData());
         reverseOrdering(((BSTNode<T>) node.getLeft()), arrayListOrder);
      }
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


   public boolean firstDegreeCousins(T elem1, T elem2) {
      boolean result = false;
      if (!isEmpty() && elem1 != null && elem2 != null) {
         BSTNode<T> node1 = search(elem1);
         BSTNode<T> node2 = search(elem2);
         if (node1.getParent().getParent().getData() != null && node2.getParent().getParent().getData() != null) {
            if (node1.getParent().getData().compareTo(node2.getParent().getData()) != 0) {
               if (node1.getParent().getParent().getData().compareTo(node2.getParent().getParent().getData()) == 0) {
                  result = true;
               }
            }
         }
      }
      return result;
   }

   public boolean secondDegreeCousins(T elem1, T elem2){
      boolean result = false;
      if(firstDegreeCousins(elem1,search(elem2).getParent().getData())){
         result = true;
      }
      else if(firstDegreeCousins(elem2,search(elem1).getParent().getData())){
         result = true;
      }
      return result;
   }

   public int countLeaves(){
      return recursiveLeavesCount(getRoot());
   }

   private int recursiveLeavesCount(BSTNode<T> node) {
      if(node.isEmpty()){
         return 0;
      }
      if(node.isLeaf()){
         return 1;
      }
      return recursiveLeavesCount(((BSTNode<T>) node.getLeft())) + recursiveLeavesCount(((BSTNode<T>)node.getRight()));
   }

   public boolean isDescentdant(T d, T p){
      boolean result = false;
      if(d != null && p != null && !search(p).isEmpty()){
         BSTNode<T> nodeParent = search(p);
         if(p.compareTo(d) < 0){
            result = recursiveIsDescendant(nodeParent.getRight(),d);
         }
         else result = recursiveIsDescendant(nodeParent.getLeft(),d);
      }
      return result;
   }

   private boolean recursiveIsDescendant(BTNode<T> otherSon, T son) {
      boolean result;
      if(otherSon.isEmpty()){
         result = false;
      }
      else if(otherSon.getData().compareTo(son) == 0){
         result = true;
      }
      else if(otherSon.getData().compareTo(son) < 0){
         result = recursiveIsDescendant(otherSon.getRight(),son);
      }
      else result = recursiveIsDescendant(otherSon.getLeft(),son);
      return result;
   }

   public int distance(T p, T d){
      int result = 0;
      if(d != null && p != null && !search(p).isEmpty() && (p.compareTo(d) != 0) && isDescentdant(d,p)){
         BSTNode<T> nodeParent = search(p);
         if(p.compareTo(d) < 0){
            result = recursiveDistance(nodeParent.getRight(),d);
         }
         else result = recursiveDistance(nodeParent.getLeft(),d);
      }
      return result;
   }

   private int recursiveDistance(BTNode<T> otherSon, T son) {
      int result;
      if(otherSon.isEmpty()){
         result = 0;
      }
      else if(otherSon.getData().compareTo(son) == 0){
         result = 1;
      }
      else if(otherSon.getData().compareTo(son) < 0){
         result = 1 + recursiveDistance(otherSon.getRight(),son);
      }
      else result = 1 + recursiveDistance(otherSon.getLeft(),son);
      return result;
   }
}