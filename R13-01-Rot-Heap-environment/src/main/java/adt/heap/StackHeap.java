package adt.heap;

import java.util.Comparator;

public class StackHeap<T extends Comparable<T>> {
    private PriorityQueue<T> structure;
    private int elements;
    private int size;

    public StackHeap(Comparator<T> comparator, int size) {
        this.elements = 0;
        this.structure = new PriorityQueue<>(comparator);
        this.size = size;
    }

    public T top() {
        T top = null;
        if (!isEmpty()) {
            top = (T) ((Position) this.structure.maximum()).getData();
        }
        else System.out.println("Pilha vazia!");
        return top;
    }

    public T pop(){
        T popped = null;
        if (!isEmpty()) {
            popped = (T) ((Position) this.structure.extractMaximum()).getData();
            elements--;
        }
        else System.out.println("Pilha vazia!");
        return popped;
    }

    public void insert(T element){
        if(!isFull()) {
            Position<T> node = new Position<>(element, this.elements);
            this.structure.insert((T) node);
            elements++;
        }
        else System.out.println("Pilha cheia!");
    }

    public int getElements() {
        return elements;
    }

    public boolean isFull(){
        return this.elements == size;
    }

    public boolean isEmpty(){
        return this.elements == 0;
    }

}
