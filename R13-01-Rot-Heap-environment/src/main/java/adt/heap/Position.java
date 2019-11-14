package adt.heap;

import java.util.Comparator;

public class Position<T extends Comparable<T>> {
    T data;
    Integer priority;

    public Position(T data, int priority) {
        this.data = data;
        this.priority = priority;
    }

    public Integer getPriority() {
        return this.priority;
    }
}
