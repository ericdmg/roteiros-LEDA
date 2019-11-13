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
      if (balance < -1) { // raiz pesada pra direita
         int childBalance = calculateBalance(((BSTNode<T>) node.getRight()));
         if (childBalance <= -1) { //raiz e filho à direita da raiz pesam pra direita = rotação simples pra esquerda
            BSTNode<T> newRoot = Util.leftRotation(node);
            if (newRoot.getParent().isEmpty()) {
               this.root = newRoot;
            }
         } else if (childBalance >= 1) {//raiz pesa pra direita e filho à direita pesa pra esquerda = rotação dupla R/L
            BSTNode<T> newSon = Util.rightRotation(((BSTNode<T>) node.getRight()));
            node.setRight(newSon);
            BSTNode<T> newRoot = Util.leftRotation(node);
            if (newRoot.getParent().isEmpty()) {
               this.root = newRoot;
            }

         }
      } else if (balance > 1) { // raiz pesada pra esquerda
         int childBalance = calculateBalance(((BSTNode<T>) node.getLeft()));
         if (childBalance >= 1) {// raiz e filho à esquerda da raiz pesam pra esquerda = rotação simples pra direita
            BSTNode<T> newRoot = Util.rightRotation(node);

            if (newRoot.getParent().isEmpty()) {
               this.root = newRoot;
            }
         } else if (childBalance <= -1) {//raiz pesa pra esquerda e filho à esquerda pesa pra direita = rotação dupla L/R
            BSTNode<T> newSon = Util.leftRotation(((BSTNode<T>) node.getLeft()));
            node.setLeft(newSon);
            BSTNode<T> newRoot = Util.rightRotation(node);
            if (newRoot.getParent().isEmpty()) {
               this.root = newRoot;
            }
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
