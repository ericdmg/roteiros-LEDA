package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

   protected DoubleLinkedList<T> list;
   protected int size;

   public QueueDoubleLinkedListImpl(int size) {
      this.size = size;
      this.list = new DoubleLinkedListImpl<T>();
   }

   @Override
   public void enqueue(T element) throws QueueOverflowException {
      if (isFull()) {
         throw new QueueOverflowException();
      } else if (element != null) {
         this.list.insert(element);
      }
   }

   @Override
   public T dequeue() throws QueueUnderflowException {
      if (isEmpty()) {
         throw new QueueUnderflowException();
      }
      T retorno = this.list.toArray()[0];
      this.list.removeFirst();
      return retorno;

   }

   @Override
   public T head() {
      T retorno = null;
      if (!isEmpty()) {
         retorno = this.list.toArray()[0];
      }
      return retorno;
   }

   @Override
   public boolean isEmpty() {
      boolean retorno = false;
      if (this.list.size() == 0) {
         retorno = true;
      }
      return retorno;
   }

   @Override
   public boolean isFull() {
      boolean retorno = false;
      if (this.size == this.list.size()) {
         retorno = true;
      }
      return retorno;
   }

}
