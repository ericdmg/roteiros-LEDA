package adt.heap;

import java.util.Comparator;

public class PriorityQueue<T extends Comparable<T>>{
    private HeapImpl<T> structure;

    public PriorityQueue(Comparator<T> comparator) {
        this.structure = new HeapImpl<T>(comparator);
    }

//    public <T extends Comparable>void insert(T element) {
//        if (element != null) {
//            getStructure().insert(element);
//        }
//
//    }

    public T maximum() {
        T maximum = null;
        if (!getStructure().isEmpty()) {
            maximum = getStructure().getHeap()[0];
        }
        return maximum;
    }

    public T extractMaximum() {
        T maximum = null;
        if (!getStructure().isEmpty()) {
            maximum = getStructure().extractRootElement();
        }
        return maximum;
    }

    public HeapImpl<T> getStructure() {
        return this.structure;
    }


}
