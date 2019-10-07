package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

   protected DoubleLinkedListNode<T> last;

   public DoubleLinkedListImpl() {
      this.head = new DoubleLinkedListNode<>();
      this.last = (DoubleLinkedListNode<T>) head;
   }


   public int firstIndex(T element){
      int index = 0;
      DoubleLinkedListNode auxHead = (DoubleLinkedListNode<T>) this.head;
      boolean achou = false;
      while(auxHead.getNext() != null && !achou){
         if(auxHead.data.equals(element)){
            achou = true;
         }
         else{
            auxHead = (DoubleLinkedListNode<T>) auxHead.next;
            index++;
         }
      }
      return index;
   }

   public int lastIndex(T element){
      int index = 0;
      int lastIndex = 0;
      DoubleLinkedListNode auxHead = (DoubleLinkedListNode<T>) this.head;
      while(auxHead.getNext() != null){
         if(auxHead.data.equals(element)){
            lastIndex = index;
         }
            auxHead = (DoubleLinkedListNode<T>) auxHead.next;
            index++;

      }
      return lastIndex;
   }



   public void removeByIndex(int index){
      int i = 0;
      DoubleLinkedListNode auxHead = (DoubleLinkedListNode<T>) this.head;
      boolean achou = false;
      while(auxHead.getNext() != null && !achou){
         if(i == index){
            remove((T) auxHead.data);
            achou = true;
         }
         else{
            auxHead = (DoubleLinkedListNode<T>) auxHead.next;
            i++;
         }
      }
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

   public void reverseList(){
      DoubleLinkedListNode<T> prev = new DoubleLinkedListNode<T>();
      DoubleLinkedListNode<T> atual =((DoubleLinkedListNode<T>) this.head);
      DoubleLinkedListNode<T> next = new DoubleLinkedListNode<T>();
      while(!atual.isNIL()){
         next = ((DoubleLinkedListNode<T>) atual.next);
         atual.next = prev;
         prev = atual;
         atual = next;
      }
      this.head = prev;
   }

}


