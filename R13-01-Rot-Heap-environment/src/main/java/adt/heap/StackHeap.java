package adt.heap;

import java.util.Comparator;

public class StackHeap<T extends Comparable<T>> {
    private PriorityQueue<T> structure;

    public int getCount() {
        return count;
    }

    private int count;

    public StackHeap(Comparator<T> comparator) {
        this.count = 0;
        this.structure = new PriorityQueue<>(comparator);
    }

    public T top(){
        return (T) ((Position) this.structure.maximum()).getData();
    }

    public T pop(){
        count--;
        return (T) ((Position) this.structure.extractMaximum()).getData();
    }

    public void insert(T element){
        Position<T> node = new Position<>(element,this.count);
        this.structure.insert((T) node);
        count++;
    }
}
