package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Implementacao de uma arvore AVL
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

   // TODO Do not forget: you must override the methods insert and remove
   // conveniently.

   @Override
   public void insert(T element) {
      if (element != null && search(element).isEmpty()) {
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
      rebalance(node);
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
         rebalanceUp(aux);
      } else if ((aux.getLeft().isEmpty() && !aux.getRight().isEmpty())) {
         aux.setData(aux.getRight().getData());
         aux.setLeft(aux.getRight().getLeft());
         aux.setRight(aux.getRight().getRight());
         rebalanceUp(aux);
      } else if ((aux.getRight().isEmpty() && !aux.getLeft().isEmpty())) {
         aux.setData(aux.getLeft().getData());
         aux.setRight(aux.getLeft().getRight());
         aux.setLeft(aux.getLeft().getLeft());
         rebalanceUp(aux);
      } else {
         T sucessor = sucessor(element).getData();
         removal(sucessor);
         aux.setData(sucessor);

      }
   }

   // AUXILIARY
   protected int calculateBalance(BSTNode<T> node) {
      return (height(((BSTNode<T>) node.getLeft())) - height(((BSTNode<T>) node.getRight())));
   }

   public int height(BSTNode<T> node) {
      int height = -1;
      if (!getRoot().isEmpty()) {
         height = getHeight(node);
      }
      return height;
   }

   // AUXILIARY
   protected void rebalance(BSTNode<T> node) {
      int balance = calculateBalance(node);
      if (balance < -1) {
         if (calculateBalance((BSTNode<T>) node.getRight()) > 0) {
            rightRotation((BSTNode<T>) node.getRight());
         }
         leftRotation(node);
      } else if (balance > 1) {
         if (calculateBalance((BSTNode<T>) node.getLeft()) < 0) {
            leftRotation((BSTNode<T>) node.getLeft());
         }
         rightRotation(node);
      }
   }

   private void rightRotation(BSTNode<T> node) {

      if (node.equals(this.getRoot())) {
         root = Util.rightRotation(node);
      } else {

         BSTNode<T> aux = Util.rightRotation(node);

         if (aux.getData().compareTo(aux.getParent().getData()) > 0)
            aux.getParent().setRight(aux);
         else
            aux.getParent().setLeft(aux);
      }
   }

   private void leftRotation(BSTNode<T> node) {

      if (node.equals(this.getRoot()))
         root = Util.leftRotation(node);
      else {

         BSTNode<T> aux = Util.leftRotation(node);

         if (aux.getData().compareTo(aux.getParent().getData()) < 0)
            aux.getParent().setLeft(aux);
         else
            aux.getParent().setRight(aux);
      }
   }

   // AUXILIARY
   protected void rebalanceUp(BSTNode<T> node) {
      BSTNode parent = ((BSTNode<T>) node.getParent());
      while (!parent.isEmpty()) {
         rebalance(((BSTNode<T>) parent));
         parent = ((BSTNode<T>) parent.getParent());
      }
   }

   public void noRotationInsertion(T[] array) {
      List<T[]> list = new ArrayList<>();
      Arrays.sort(array);
      list.add(array);

      int i = 0;
      while (i < list.size()) {
         T[] aux = list.get(i);

         int mid = aux.length / 2;
         T[] aux1 = Arrays.copyOfRange(aux, 0, mid);
         T[] aux2 = Arrays.copyOfRange(aux, mid+1, aux.length);

         if (i > 1) {
            list.add(aux1);
            list.add(aux2);
         }

         insert(array[mid]);
         i++;

      }
   }
}
