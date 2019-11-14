package adt.heap;

import java.util.Comparator;

public class PriorityQueue<T extends Comparable<T>>{
    private HeapImpl<T> structure;

    public PriorityQueue(Comparator<T> comparator) {
        this.structure = new HeapImpl<T>(comparator);
    }


}
