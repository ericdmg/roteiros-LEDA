package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

   protected DoubleLinkedListNode<T> last;

   public DoubleLinkedListImpl() {
      this.head = new DoubleLinkedListNode<>();
      this.last = (DoubleLinkedListNode<T>) head;
   }

   @Override
   public void insertFirst(T element) {
      if(element != null){
         DoubleLinkedListNode newHead = new DoubleLinkedListNode(element, (DoubleLinkedListNode) this.head,
                 new DoubleLinkedListNode());
         ((DoubleLinkedListNode<T>) this.head).setPrevious(newHead);
         if (this.head.isNIL()) {
            setLast(newHead);
         }
         this.head = newHead;
       }
   }

   @Override
   public void insert(T element) {
      if(element != null){
         DoubleLinkedListNode auxHead = (DoubleLinkedListNode<T>) this.head;
         if (this.head.isNIL()) {
            DoubleLinkedListNode newHead = new DoubleLinkedListNode(element, (DoubleLinkedListNode) this.head,
                    new DoubleLinkedListNode());
            this.head = newHead;
         } else {
            while (!auxHead.next.isNIL()) {
               auxHead = (DoubleLinkedListNode<T>) auxHead.next;
            }
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(element, new DoubleLinkedListNode(), auxHead);
            auxHead.next = (DoubleLinkedListNode<T>) newNode;
            setLast(newNode);

         }
      }
   }

   @Override
   public void removeFirst() {
      if (!this.head.isNIL()) {
         this.head = this.head.next;
         if (this.head.isNIL()) {
            setLast((DoubleLinkedListNode<T>) this.head);
         }
      }
   }

   @Override
   public void removeLast() {
      if (!this.last.isNIL()) {
         this.last = this.last.previous;
         if (this.last.isNIL()) {
            this.head = this.last;
         }
         this.last.next = new DoubleLinkedListNode<>();
      }
   }

   public DoubleLinkedListNode<T> getLast() {
      return this.last;
   }

   public void setLast(DoubleLinkedListNode<T> last) {
      this.last = last;
   }

}
