package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

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
         rebalance(getRoot());
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
   public void remove(T element) {
      if (!getRoot().isEmpty() && element != null && !search(element).isEmpty()) {
         removal(element);
         rebalance(getRoot());
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
      if (balance <= -1) { // raiz pesada pra direita
         int childBalance = calculateBalance(((BSTNode<T>) node.getRight()));
         if (childBalance < -1 || childBalance <= -1 && node.getRight().getLeft().isEmpty()) { //raiz e filho à direita da raiz pesam pra direita = rotação simples pra esquerda
            this.root = Util.leftRotation(node);
         } else if (childBalance > 1 || childBalance >= 1 && node.getRight().getRight().isEmpty()) {//raiz pesa pra direita e filho à direita pesa pra esquerda = rotação dupla R/L
            BSTNode<T> newSon = Util.rightRotation(((BSTNode<T>) node.getRight()));
            node.setRight(newSon);
            BSTNode<T> newRoot = Util.leftRotation(node);
            this.root = newRoot;
         }
      } else if (balance >= 1) { // raiz pesada pra esquerda
         int childBalance = calculateBalance(((BSTNode<T>) node.getLeft()));
         if (childBalance > 1 || childBalance >= 1 && node.getLeft().getRight().isEmpty()) {// raiz e filho à esquerda da raiz pesam pra esquerda = rotação simples pra direita
            this.root = Util.rightRotation(node);
         } else if (childBalance < -1 || childBalance <= -1 && node.getLeft().getLeft().isEmpty()) {//raiz pesa pra esquerda e filho à esquerda pesa pra direita = rotação dupla L/R
            BSTNode<T> newSon = Util.leftRotation(((BSTNode<T>) node.getLeft()));
            node.setLeft(newSon);
            BSTNode<T> newRoot = Util.rightRotation(node);
            this.root = newRoot;
         }
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
}
